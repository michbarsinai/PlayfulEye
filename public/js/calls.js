function callAsync() {
  $.ajax( jsRoutes.controllers.Examples.asyncEcho("Async") )
         .done( function(res){
          $("#console").append(res + "\n");
          }
        );
}

function callSync() {
  $.ajax( jsRoutes.controllers.Examples.syncEcho("Sync") )
       .done( function(res){
        $("#console").append(res + "\n");
        }
      );
}