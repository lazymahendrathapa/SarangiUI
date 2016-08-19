<!DOCTYPE html>

<html lang="en">
    <head>
        <title>Sarangi</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <script src="resources/core/js/bootstrap.min.js"></script>
        <script src="resources/core/js/sarangi.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <link href="resources/core/css/bootstrap.min.css" rel="stylesheet" />
        <link href="resources/core/css/sarangi.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Denk One">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

    </head>

    <body style="font-family:Denk One">

        <div class="container-fluid bg-1 ">

            <br />
            <br/>
            <br/>
            <h1 class ="text-center">SARANGI</h1>
            <br/>
            <br/>
            <br/>

            <form action="" method="POST"  enctype="multipart/form-data">

                <div class="col-lg-3 col-sm-3 col-12">
                </div>

                <div class="col-lg-6 col-sm-6 col-12">
                    <div class="input-group">
                        <label class="input-group-btn">
                            <span class="btn btn-primary">
                                Browse&hellip; <input  type="file" name="file" style="display: none;" multiple accept=".mp3,.wav,.au,.ogg">
                            </span>
                        </label>
                        <input type="text" class="form-control" name="desc" readonly>
                    </div>
                    <br/>
                    <input type="submit" class="btn btn-default" value="submit">

                </div>

            </form>

        </div>


        <hr>
 
        <div class="col-lg-3 col-sm-3 col-12">
        </div>

       <div class="col-lg-6 col-sm-6 text-center">
        <h3> ${song.songName}</h3>

        <c:choose>
        <c:when test="${(fn:length(song.songError) != 0) || (fn:length(song.songStatus) != 0)}">
        <h4 class = "alert alert-danger"> Something Error</h4>
        </c:when>

        <c:when test="${fn:length(song.songGenre) != 0}">
        <h4 class = "alert alert-info">${song.songGenre}</h4>
        <h4 class = "alert alert-warning">${song.songArousal}</h4>
        <h4 class = "alert alert-success">${song.songValence}</h4>
        </c:when>

        </c:choose>

        </div>

        <script>
                                             $(function() {

                                             // We can attach the `fileselect` event to all file inputs on the page
                                             $(document).on('change', ':file', function() {
                                             var input = $(this),
                                             numFiles = input.get(0).files ? input.get(0).files.length : 1,
                                             label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
                                             input.trigger('fileselect', [numFiles, label]);
                                             });

                                             // We can watch for our custom `fileselect` event like this
                                             $(document).ready( function() {
                                             $(':file').on('fileselect', function(event, numFiles, label) {

                                             var input = $(this).parents('.input-group').find(':text'),
                                             log = numFiles > 1 ? numFiles + ' files selected' : label;

                                             if( input.length ) {
                                             input.val(log);
                                             } else {
                                             if( log ) alert(log);
                                             }

                                             });
                                             });

                                             });

        </script>

    </body>
</html>
