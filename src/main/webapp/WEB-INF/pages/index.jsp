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
    </head>

    <body>

        <div class="container-fluid bg-1 ">

            <h1 class ="text-center">SARANGI</h1>

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

                    <input type="submit" value="submit">

                </div>

            </form>

        </div>



        ${song.songName}
        ${song.songStatus}

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
