package uk.ac.le.cs.CO3098.cw3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import uk.ac.le.cs.CO3098.cw3.domain.Folder;
import uk.ac.le.cs.CO3098.cw3.domain.Link;
import uk.ac.le.cs.CO3098.cw3.domain.Location;
import uk.ac.le.cs.CO3098.cw3.domain.TextFile;
import uk.ac.le.cs.CO3098.cw3.repository.FolderRepository;
import uk.ac.le.cs.CO3098.cw3.repository.LinkRepository;
import uk.ac.le.cs.CO3098.cw3.repository.LocationRepository;
import uk.ac.le.cs.CO3098.cw3.repository.TextRepository;

@RestController
@RequestMapping(value="/service")
public class ServiceController {
	
	@Autowired
	FolderRepository fr;
	
	@Autowired
	TextRepository tr;
	
	@Autowired
	LocationRepository locr;
	
	@Autowired
	LinkRepository lnkr;
	
	
	
	/*Adding a bookmark folder to an existing folder, if exists, if not, create folder.*/
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public @ResponseBody String createFolder(
			@RequestParam (value ="folder") String folder,
			@RequestParam (value = "parent",required = false) String parent ) {
		
	//Folder supplied is empty
		if(folder == null || folder.isEmpty()) {
			return "false";
		}
	//Folder is supplied but no parent supplied	
		if (folder != null && (parent == null || parent.isEmpty())) {
			if(fr.findByPath(folder) != null) {
				return "false";
			}
			
			Folder f = new Folder(folder);			
			f.setParentFolder(null);
			f.setIsRootNode(true);
			f.setPath(folder);
			fr.save(f);
			return "true";
		}
	//Folder and parent both supplied
		parent = parent.replace('|', '/');
		//checking for duplicates in repo.
		if (fr.findByPath(parent+"/"+folder) != null) {    // != null = exists
			return "false";
			//both parent and folder are supplied
		} else if (folder != null && fr.findByPath(parent) != null) {
			
			Folder f = new Folder(folder);
			Folder parentf = fr.findByPath(parent);
			List<Folder> subfolders = parentf.getSubfolders();

			f.setReadOnly(false);
			f.setPath(parent + "/" + folder);
			f.setParentFolder(parentf);
			subfolders.add(f);
			
			fr.save(f);
			fr.save(parentf);
			return "true";

		} else {
			return "false";
		}

		
	}	
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public @ResponseBody String deleteFolder(
			@RequestParam (value ="folder") String folder) {
				
		folder = folder.replace('|', '/');
		
		//No folder supplied
		if(folder == null || folder.isEmpty()) {
			return "false";
		}
		//Folder supplied but folder doesn't exist in db
		if(folder != null && fr.findByPath(folder) == null){
			return "false";
		}
		
//folder supplied exists in db
		
		//Folder with no children
		if(fr.findByPath(folder).getSubfolders() == null) {

			Folder f = new Folder(folder);
			f = fr.findByPath(folder);
			fr.delete(f);

		}	
		//Folder has subchildren
		
		if(fr.findByPath(folder).getSubfolders() != null) {	
			
				for(int i=0; i<fr.findByPath(folder).getSubfolders().size();i++) {
					fr.delete(fr.findByPath(folder).getSubfolders().get(i));
				}
			
			
				fr.delete(fr.findByPath(folder));
					
			return "true";
		
		
		}else {
			
			
			return "false";
	}
	
	
}
	
		
		
		
		@RequestMapping(value="/structure", method = RequestMethod.GET)
		public @ResponseBody String displayStructure(
				@RequestParam (value = "folder") String folder) {
			
			folder = folder.replace('|', '/');
			
			
			List <Folder> f =  new ArrayList<Folder>();
			
			
			//Checking if we are at root node, since root node has no parent.
			if (fr.findByPath(folder).getParentFolder() == null) {
				f = fr.findByPath(folder).getSubfolders();
			}else {
				f = fr.findByPath(folder).getParentFolder().getSubfolders();
			}
			
			Gson gson = new GsonBuilder()
					.setPrettyPrinting()
					.excludeFieldsWithoutExposeAnnotation()
					.create();
			
			//Needs work = Gson displaying empty arrays that dont have children(leaf nodes)
			
			
			String json = gson.toJson(f);
			return json;
			
			
		}
		
		@RequestMapping(value="/count", method = RequestMethod.GET)
		public @ResponseBody String displayCount(
				@RequestParam (value = "folder") String folder) {
			
			folder = folder.replace('|', '/');
			
/*			get parent id and store
			traverse list and see if id reoccurs{
				if it does = direct label + 1, else increase indirect.
			*/
			
			
			/*indirect:books.subfolder.size()*/
			return "";
		}
		
		@RequestMapping(value="/createStructure", method = RequestMethod.GET)
		public @ResponseBody String createTree(
				@RequestParam(value = "tree") String tree,
				@RequestParam(value = "root") String root){
			
				
				return "";
					
				}
		
		@RequestMapping(value="/createText", method = RequestMethod.GET)
		public @ResponseBody String createText(
				@RequestParam (value ="parent") String parent,
				@RequestParam (value = "title") String title,
				@RequestParam (value = "text" ) String text) {
			
				//Check parameters are not empty/null
				if(title == null || text == null || parent == null) {
					return "false";
				}
				
				//Title and Text supplied but parent is empty
				if(title != null && text != null &&(parent == null || parent.isEmpty())) {
					return "false";
				}
				
				//Check for duplicates
				if(fr.findByPath(parent+"/"+title) != null) {
					return "false";
				}
				
				//All parameters supplied
				parent = parent.replace('|', '/');

				if(title != null && text != null && fr.findByPath(parent) != null) {
					
					TextFile tf = new TextFile(title);
					Folder pf = fr.findByPath(parent);
					List<TextFile> subTextFiles = pf.getTextFiles();
					
					
					tf.setReadOnly(false);
					tf.setTitle(title);
					tf.setText(text);
					tf.setParentFolder(pf);
					subTextFiles.add(tf);
					tf.setPath(parent+"/"+title);
					
					
					tr.save(tf);
					return "true";
				}else {
					return "false";
			
				}
		}		
		
		@RequestMapping(value="/createLocation", method = RequestMethod.GET)
		public @ResponseBody String createLocation(
				@RequestParam (value ="parent") String parent,
				@RequestParam (value = "location") String location,
				@RequestParam (value = "latitude" ) double latitude,
				@RequestParam (value = "longitude")double longitude) {
			
				//Check parameters are not empty/null
				if(location == null || latitude == 0.0 || longitude == 0.0 || parent == null) {
					return "false";
				}
				
				//Parameters supplied but parent is empty
				if(location != null && latitude != 0.0  && longitude != 0.0 && (parent == null || parent.isEmpty())) {
					return "false";
				}
				
				//Check for duplicates
				if(fr.findByPath(parent+"/"+location) != null) {
					return "false";
				}
				
				//All parameters supplied & not a duplicate
				parent = parent.replace('|', '/');

				if(location != null && latitude != 0.0 && longitude != 0.0 && fr.findByPath(parent) != null) {
					
					Location lf = new Location(location);
					Folder pf = fr.findByPath(parent);
					List<Location> subLocationFiles = pf.getLocationFiles();
					
					
					lf.setReadOnly(false);
					lf.setName(location);
					lf.setLatitude(latitude);
					lf.setLongitude(longitude);
					subLocationFiles.add(lf);
					lf.setPath(parent+"/"+location);
					lf.setParentFolder(pf);
					
					
					locr.save(lf);
					return "true";
				}else {
					return "false";
			
				}
		}	
		
		@RequestMapping(value="/createLink", method = RequestMethod.GET)
		public @ResponseBody String createLink(
				@RequestParam (value ="parent") String parent,
				@RequestParam (value = "title") String title,
				@RequestParam (value = "url" ) String url) {
			
				//Check parameters are not empty/null
				if(title == null || url == null || parent == null) {
					return "false";
				}
				
				//Title and Text supplied but parent is empty
				if(title != null && url != null &&(parent == null || parent.isEmpty())) {
					return "false";
				}
				
				//Check for duplicates
				if(fr.findByPath(parent+"/"+title) != null) {
					return "false";
				}
				
				//All parameters supplied
				parent = parent.replace('|', '/');

				if(title != null && url != null && fr.findByPath(parent) != null) {
					
					Link lf = new Link(title);
					Folder pf = fr.findByPath(parent);
					List<Link> linkFiles = pf.getLinkFiles();
					
					
					lf.setReadOnly(false);
					lf.setTitle(title);
					lf.setUri(url);
					lf.setParentFolder(pf);
					linkFiles.add(lf);
					lf.setPath(parent+"/"+title);
					
					
					lnkr.save(lf);
					return "true";
				}else {
					return "false";
			
				}
		}
		
}




