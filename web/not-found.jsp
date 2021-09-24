<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="shortcut icon" href="assets/images/favicon_1.ico">

        <title>GiftHack | 404 - Not Found</title>

        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/core.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/components.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/pages.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/responsive.css" rel="stylesheet" type="text/css" />

        <script src="assets/js/modernizr.min.js"></script>
        
    </head>

    <body>
        <div class="container">
            <div class="wrapper-page">
                <div class="ex-page-content text-center">
                        <div class="text-error">
                                <span class="text-primary">4</span><i class="ti-face-sad text-pink"></i><span class="text-info">4</span>
                        </div>
                        <h2>Who0ps! Page not found</h2>
                        <br>
                        <p class="text-muted">
                                This page cannot found or is missing.
                        </p>
                        <br>
                        <a class="btn btn-default waves-effect waves-light" href="<%=request.getContextPath()%>/lists"> Return Home</a>

                </div>
            </div>
        <!-- end wrapper page -->
        </div>
    </body>
</html>
