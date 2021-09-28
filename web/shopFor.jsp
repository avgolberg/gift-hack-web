<%@page import="data.ReservedGift"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.GiftList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    ArrayList<ReservedGift> reservedGifts = (ArrayList<ReservedGift>)request.getAttribute("reservedGifts");
%>
<!DOCTYPE html>
<html>
    <meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<link rel="shortcut icon" href="assets/images/favicon_1.ico">

		<title>GiftHack | Shop For</title>    
                
	<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="assets/css/core.css" rel="stylesheet" type="text/css">
        <link href="assets/css/components.css" rel="stylesheet" type="text/css">
        <link href="assets/css/icons.css" rel="stylesheet" type="text/css">
        <link href="assets/css/pages.css" rel="stylesheet" type="text/css">
        <link href="assets/css/responsive.css" rel="stylesheet" type="text/css">

        <script src="assets/js/modernizr.min.js"></script>

	</head>

	<body class="widescreen fixed-left">
		<!-- Begin page -->
		<div id="wrapper" class="forced">

            <!-- Top Bar Start -->
            <div class="topbar">

                <!-- LOGO -->
                <div class="topbar-left" style="width: 210px;">
                    <div class="text-center">
                        <a href="<%=request.getContextPath()%>/lists" class="logo"><span><img src="assets/images/logo_white.png" height="55"/></span></a>
                    </div>
                </div>

                <!-- Button mobile view to collapse sidebar menu -->
                <div class="navbar navbar-default" role="navigation">
                    <div class="container">
                        <div class="">
                            <div class="pull-left">
                                
                                <span class="clearfix"></span>
                            </div>

                            <ul class="nav navbar-nav hidden-xs">
                                <li><a href="<%=request.getContextPath()%>/lists" class="waves-effect waves-light">Lists</a></li>
                            </ul>
                            
                             <ul class="nav navbar-nav hidden-xs">
                                <li><a href="<%=request.getContextPath()%>/shop-for" class="waves-effect waves-light">Shop For</a></li>
                            </ul>
                            
                            <ul class="nav navbar-nav navbar-right pull-right">
                                <li><a href="/GiftHack/login?logout=1"> Logout</a></li>
                            </ul>
                        </div>
                        <!--/.nav-collapse -->
                    </div>
                </div>
            </div>
            <!-- Top Bar End -->

            <!-- Start right Content here -->
            <!-- ============================================================== -->
            <div class="content-page" style="margin-left: 20px;">
                    <!-- Start content -->
                    <div class="content">
                            <div class="container">
                                    <!-- Page-Title -->
                            <h3>Reserved gifts by you are: </h3> <br/>
                          
                           <div class="panel">
                            
                           <div class="p-20">
                            <table class="table table table-hover m-0">
                                    <thead>
                                            <tr>
                                                    <th>#</th>
                                                    <th>Whom</th>
                                                    <th>Gift name</th>
                                                    <th>Quantity</th>
                                                    <th>Ranking</th>
                                                    <th>Where to buy</th>
                                                    <th>Comment</th>
                                                    <th>Actions</th>
                                            </tr>
                                    </thead>
                                    <tbody>
                                        <% int i = 1; for(ReservedGift gift : reservedGifts){ %>
                                            <tr>
                                                    <th scope="row"><%= i %></th>
                                                    <td><%= gift.getAuthorName() %></td>
                                                    <td><%= gift.getGiftName()%></td>
                                                    <td><%= gift.getQuantity() %></td>
                                                    <td><%= gift.getRanking() %></td>
                                                    <td><%= gift.getLink() %></td>
                                                    <td><%= gift.getComment()%></td>
                                                    <td>
                                                      <a href="/GiftHack/bought-gift?id=<%= gift.getGiftId() %>" class="on-default edit-row"><i class="md md-wallet-giftcard"></i></a>
                                                    </td>
                                            </tr>
                                            <% i++; %>
                                        <% } %>
                                    </tbody>
                            </table>
                    </div>
                </div> <!-- content -->

                

            </div>
            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->

        </div>
        <!-- END wrapper -->

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


        <script src="assets/js/jquery.core.js"></script>
        <script src="assets/js/jquery.app.js"></script>
        	
	 <script src="assets/pages/datatables.editable.init.js"></script>
</body></html>