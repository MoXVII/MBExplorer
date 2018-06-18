<!DOCTYPE html>
<html lang="en">
<head>
  <title>MBExplorer</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="bootstrap.css" rel="stylesheet">
  <script src="bootstrap-treeview.js"></script>
</head>
<body>

<div class="jumbotron text-center">
  <h1>Welcome to My Bookmark Explorer</h1>
  <p>All your bookmarks in one place.</p> 
</div>
  
<div class="container">
  <div class="row">
    <div class="col-sm-6">
    <div id="tree">
      <h3>Tree:</h3>
      <p>Display here</p>
    
    
    </div>
    </div>
    <div class="col-sm-6">
      <h3>What would you like to add?</h3>
      <button class="btn btn btn-success btn-lg" data-toggle="modal" data-target="#rootModal">Root Folder</button>
      <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#folderModal">Folder</button>
      <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#textModal"> Text</button>
      <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#locationModal"> Location</button>
      <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#linkModal"> Link</button>
   
  <!-- /RootModal/ -->   
    <div class="modal fade" id="rootModal" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal">
                       <span aria-hidden="true">&times;</span>
                       <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Create a Root Folder
                </h4>
            </div>
            
            <!-- Modal Body -->
            <div class="modal-body">
					<div class="row">
					<div class="col col-md-8">
					<input type="text" class="form-control" id="rootFolderName" />
					</div>
					<div class="col col-md-4">
					<button id="submitRootButton" class="btn btn-success">Create Root Folder</button>
 
					</div>
					</div>					
            </div>
        </div>
    </div>
</div>


 <!-- /folderModal/ -->   
    <div class="modal fade" id="folderModal" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal">
                       <span aria-hidden="true">&times;</span>
                       <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Create a Folder
                </h4>
            </div>
            
            <!-- Modal Body -->
            <div class="modal-body">
 	            <form class="form-horizontal" role="form">
                  <div class="form-group">
                    <label  class="col-sm-2 control-label"
                              for="folderInput">Folder Name:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" 
                        id="folderName" name="folder" placeholder="Name of the folder to add?"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label"
                          for="parentInput" >Parent Folder:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control"
                            id="parentName" name="parent" placeholder="Where is this folder to be placed?"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button id="submitFolderButton" class="btn btn-default">Create</button>
                    </div>
                  </div>
                </form>             
            </div>
        </div>
    </div>
</div>

                
 <!-- /TextModal/ --> 
     <div class="modal fade" id="textModal" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal">
                       <span aria-hidden="true">&times;</span>
                       <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Save a Text-File
                </h4>
            </div>
            
            <!-- Modal Body -->
            <div class="modal-body">
                
                <form class="form-horizontal" role="form">
                   <div class="form-group">
                    <label class="col-sm-2 control-label"
                          for="parentInput" >Parent Folder:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control"
                            id="texParent" name="parent" placeholder="Where is this folder to be placed?"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label  class="col-sm-2 control-label"
                              for="folderInput">Title:</label>
                    <div class="col-sm-10">  
                       <input type="text" class="form-control"
                            id="texTitle" name="title" placeholder="What is this text about?"/>	  
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label"
                          for="parentInput" >Text:</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" name="textVal" id="textVal"></textarea></div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button id="submitTextButton" class="btn btn-default">Create</button>
                    </div>
                  </div>
                </form>   
            </div>
        </div>
    </div>
</div>
 <!-- /LocationModal/ --> 
  <div class="modal fade" id="locationModal" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal">
                       <span aria-hidden="true">&times;</span>
                       <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Save a Location
                </h4>
            </div>
            
            <!-- Modal Body -->
            
            <div class="modal-body">
            <form class="form-horizontal" role="form">
                  <div class="form-group">
                    <label class="col-sm-2 control-label"
                          for="parentInput" >Parent Folder:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control"
                            id="locParent" name="parent" placeholder="Where is this folder to be placed?"/>
                    </div>
                  </div>
                   <div class="form-group">
                    <label  class="col-sm-2 control-label"
                              for="folderInput">Location Name:</label>
                    <div class="col-sm-10">  
                       <input type="text" class="form-control"
                            id="locTitle" name="title" placeholder="Location"/>	  
                    </div>
                  </div>
                   <div class="form-group">
                    <label  class="col-sm-2 control-label"
                              for="folderInput">Latitude:</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" 
                        id="latitude" name="latitude" placeholder="Latitude"/>
                    </div>
                  </div>
                   <div class="form-group">
                    <label  class="col-sm-2 control-label"
                              for="folderInput">Longitude:</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" 
                        id="longitude" name="longitude" placeholder="Longitude"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button id ="submitLocationButton" class="btn btn-default">Create</button>
                    </div>
                  </div>
                  </form>
            </div>
        </div>
    </div>
</div>
 
 <!-- /LinkModal/ --> 
  <div class="modal fade" id="linkModal" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal">
                       <span aria-hidden="true">&times;</span>
                       <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Save a Link
                </h4>
            </div>
            
            <!-- Modal Body -->
            <div class="modal-body">
                
                <form class="form-horizontal" role="form">
                  <div class="form-group"> 
                    <label class="col-sm-2 control-label"
                          for="parentInput" >Parent Folder:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control"
                            id="urlParent" name="urlParent" placeholder="Where is this folder to be placed?"/>
                    </div>
                  </div>
                   <div class="form-group">
                    <label  class="col-sm-2 control-label"
                              for="folderInput">Title:</label>
                    <div class="col-sm-10">  
                       <input type="text" class="form-control"
                            id="urlTitle" name="urlTitle" placeholder="What is this site about?"/>	  
                    </div>
                  </div>
                   <div class="form-group">
                    <label  class="col-sm-2 control-label"
                              for="folderInput">URL:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" 
                        id="url" name="url" placeholder="URL"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button id="submitURLButton" class="btn btn-default">Create</button>
                    </div>
                  </div>
                </form>             
            </div>
        </div>
    </div>
</div>
    
    </div>
  </div>
</div>


<script type="text/javascript">
$(document).ready(function(){
	
	$("#submitRootButton").on("click", function(){
		
		var rootval = $("#rootFolderName").val();
			$.ajax({
			    type: 'GET',
			    url: "/service/create?folder="+rootval,
			    cache: false,
			    success: function (res) {
			        if (res == "true") {
			            alert("The root folder has been added.");
			        } else {
			            alert("Something went wrong.");
			        }
			    }
			});
	});

	
	$("#submitFolderButton").on("click", function(){
		
		var folderval = $("#folderName").val();
		var parentval = $("#parentName").val();
			$.ajax({
			    type: 'GET',
			    url: "/service/create?folder="+folderval+"&parent="+parentval,
			    cache: false,
			    success: function (res) {
			        if (res == "true") {
			            alert("The folder has been added.");
			        } else {
			            alert("Something went wrong.");
			        }
			    }
			});
	});
	
	
	
	$("#submitTextButton").on("click", function(){
		
		var parentval = $("#texParent").val();
		var titleval = $("#texTitle").val();
		var textval = $("#textVal").val();
			$.ajax({
			    type: 'GET',
			    url: "/service/createText?parent="+parentval+"&title="+titleval+"&text="+textval,
			    cache: false,
			    success: function (res) {
			        if (res == "true") {
			            alert("The textfile has been added.");
			        } else {
			            alert("Something went wrong.");
			        }
			    }
			});
	});
	
	$("#submitLocationButton").on("click", function(){
			
			var parentval = $("#locParent").val();
			var title = $("#locTitle").val();
			var latitude = $("#latitude").val();
			var longitude = $("#longitude").val();
			console.log("/service/createLocation?parent="+parentval+"&location="+title+"&latitude="+latitude+"&longitude="+longitude);
				$.ajax({
				    type: 'GET',
				    url: "/service/createLocation?parent="+parentval+"&location="+title+"&latitude="+latitude+"&longitude="+longitude,
				    cache: false,
				    success: function (res) {
				        if (res == "true") {
				            alert("The location has been added.");
				        } else {
				            alert("Something went wrong.");
				        }
				    }
				});
		});
	
$("#submitURLButton").on("click", function(){
		
		var parentval = $("#urlParent").val();
		var titleval = $("#urlTitle").val();
		var urlval = $("#url").val();
			$.ajax({
			    type: 'GET',
			    url: "/service/createLink?parent="+parentval+"&title="+titleval+"&url="+urlval,
			    cache: false,
			    success: function (res) {
			        if (res == "true") {
			            alert("The Link has been added.");
			        } else {
			            alert("Something went wrong.");
			        }
			    }
			});
	});
	
	
	
});



</script>
</body>
</html>
