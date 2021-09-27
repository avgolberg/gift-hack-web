<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.UUID"%>
<!DOCTYPE html>
<html>
   	<head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <link rel="shortcut icon" href="assets/images/favicon_1.ico">

            <title>GiftHack | New gift</title>

        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/core.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/components.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/pages.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/responsive.css" rel="stylesheet" type="text/css" />

        <script src="web/assets/js/modernizr.min.js"></script>
        
        </head>
    <body>
         <div class="account-pages"></div>
            <div class="clearfix"></div>
            <div class="wrapper-page">
                    <div class=" card-box">
                <div class="panel-heading"> 
                    <h3 class="text-center"> <strong class="text-custom">Add new gift</strong> </h3>
                </div> 

           <div class="panel-body">
                <form class="form-horizontal m-t-20"  action="" method="post">

                    <div class="form-group ">
                        <div class="col-xs-12">
                            <input class="form-control" parsley-trigger="change" type="text" required="" name="name" placeholder="Gift name">
                        </div>
                    </div>
                    
                     <div class="form-group ">
                        <div class="col-xs-12">
                            <input class="form-control" data-parsley-type="number"  type="text" required="" name="quantity" placeholder="Quantity">
                        </div>
                    </div>
                    
                     <div class="form-group ">
                        <div class="col-xs-12">
                            <input class="form-control" parsley-trigger="change" type="text" required="" name="link" placeholder="Where to buy (link, shop name...)">
                        </div>
                    </div>
                    
                     <div class="form-group ">
                        <div class="col-xs-12">
                            <input class="form-control" data-parsley-min="1" data-parsley-max="5" type="text" required="" name="ranking" placeholder="Ranking 1 to 5">
                        </div>
                    </div>
                    
                    <div class="form-group ">
                        <div class="col-xs-12">
                            <input class="form-control" type="text" name="comment" placeholder="Comment">
                        </div>
                    </div>
                    
                    <div class="form-group ">
                        <div class="col-xs-12">
                            <input class="form-control" type="hidden" name="authorId" value="<%= session.getAttribute("userId") %>">
                        </div>
                    </div>

                    <div class="form-group text-center m-t-40">
                        <div class="col-xs-12">
                            <button class="btn btn-info btn-block text-uppercase waves-effect waves-light" type="submit"> Save</button>
                        </div>
                    </div>
                </form> 
            </div>   
            </div>
        </div>
                        
        <script>
                var resizefunc = [];
        </script>
                  <!-- jQuery  -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/detect.js"></script>
        <script src="assets/js/fastclick.js"></script>
        <script src="assets/js/jquery.slimscroll.js"></script>
        <script src="assets/js/jquery.blockUI.js"></script>
        <script src="assets/js/waves.js"></script>
        <script src="assets/js/wow.min.js"></script>
        <script src="assets/js/jquery.nicescroll.js"></script>
        <script src="assets/js/jquery.scrollTo.min.js"></script>
        
        <script src="assets/plugins/notifyjs/js/notify.js"></script>
        <script src="assets/plugins/notifications/notify-metro.js"></script>

        <script src="assets/js/jquery.core.js"></script>
        <script src="assets/js/jquery.app.js"></script>

        <script type="text/javascript" src="assets/plugins/parsleyjs/parsley.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                    $('form').parsley();
            });
        </script>
    </body>
</html>
