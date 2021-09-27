<%@page import="data.Gift"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.GiftList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    ArrayList<GiftList> giftLists = (ArrayList<GiftList>)request.getAttribute("lists");
    ArrayList<Gift> gifts = (ArrayList<Gift>)request.getAttribute("gifts");
    boolean isListAuthor = false;
    if(request.getAttribute("authorId")!=null && request.getAttribute("authorId").equals(session.getAttribute("userId"))) isListAuthor = true;
    int userId = Integer.parseInt((String)session.getAttribute("userId"));
%>
<!DOCTYPE html>
<html>
    <meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<link rel="shortcut icon" href="assets/images/favicon_1.ico">

		<title>GiftHack | Lists</title>    
                
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
                <div class="topbar-left">
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
                            
<!--                             <ul class="nav navbar-nav hidden-xs">
                                <li><a href="#" class="waves-effect waves-light">Groups</a></li>
                            </ul>-->

<!--                            <form role="search" class="navbar-left app-search pull-left hidden-xs">
			                     <input type="text" placeholder="Find a memeber..." class="form-control">
			                     <a href=""><i class="fa fa-search"></i></a>
			                </form>-->
                            <ul class="nav navbar-nav navbar-right pull-right">
                                <li><a href="/GiftHack/login?logout=1"><i class="ti-power-off m-r-10 text-danger"></i> Logout</a></li>
                            </ul>
                        </div>
                        <!--/.nav-collapse -->
                    </div>
                </div>
            </div>
            <!-- Top Bar End -->

            <!-- Start right Content here -->
            <!-- ============================================================== -->
            <div class="content-page">
                    <!-- Start content -->
                    <div class="content">
                            <div class="container">
                                    <!-- Page-Title -->
                                        <% if(giftLists!=null) { %>
                                            <h3> Hi, <%= session.getAttribute("username") %>! Yout gift lists are: </h3> <br/>
                                           <form action="<%=request.getContextPath()%>/new-list" method="get">            
<!--                                               <a href="/GiftHack/lists?new=1">-->
                                                   <button type="submit" class="btn btn-default waves-effect waves-light">New List</button>
<!--                                               </a>-->
                                            </form> <br/>
                                    <div class="panel">
                            
                           <div class="p-20">
                            <table class="table table table-hover m-0">
                                    <thead>
                                            <tr>
                                                    <th>#</th>
                                                    <th>Name</th>
                                                    <th>Link to share, view and change</th>
                                                    <th>Actions</th>
                                            </tr>
                                    </thead>
                                    <tbody>
                                        <% int i = 1; for(GiftList giftlist : giftLists){ %>
                                            <tr>
                                                    <th scope="row"><%= i %></th>
                                                    <td><%= giftlist.getName() %></td>
                                                    <td><a href="/GiftHack/lists?id=<%= giftlist.getId()%>">/GiftHack/lists?id=<%= giftlist.getId()%></a></td>
                                                    <td>
                                                        <a href="/GiftHack/edit-list?id=<%= giftlist.getId() %>" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
                                                        <a href="/GiftHack/delete-list?id=<%= giftlist.getId() %>" class="on-default remove-row"><i class="fa fa-trash-o"></i></a>
                                                    </td>
                                            </tr>
                                            <% i++; %>
                                        <% } %>
                                    </tbody>
                            </table>
                    </div>
                <% } else { %>
                <h3> Hi, <%= session.getAttribute("username") %>! Gifts from list <strong class="text-custom"><%= request.getAttribute("listName") %></strong>  are: </h3> <br/>
                          <a href="<%=request.getContextPath()%>/new-gift?listId=<%= request.getAttribute("listId") %>" class="on-default edit-row">
                           <button type="submit" class="btn btn-default waves-effect waves-light">New Gift</button> </a>
                           <br/>
                           
                           <div class="panel">
                            
                           <div class="p-20">
                            <table class="table table table-hover m-0">
                                    <thead>
                                            <tr>
                                                    <th>#</th>
                                                    <th>Name</th>
                                                    <th>Quantity</th>
                                                    <th>Ranking</th>
                                                    <th>Where to buy</th>
                                                    <th>Comment</th>
                                                    <th>Actions</th>
                                            </tr>
                                    </thead>
                                    <tbody>
                                        <% int i = 1; for(Gift gift : gifts){ %>
                                            <tr>
                                                    <th scope="row"><%= i %></th>
                                                    <td><%= gift.getName() %></td>
                                                    <td><%= gift.getQuantity() %></td>
                                                    <td><%= gift.getRanking() %></td>
                                                    <td><%= gift.getLink() %></td>
                                                    <td><%= gift.getComment()%></td>
                                                    <% if(isListAuthor){ %>
                                                    <td>
                                                        <a href="/GiftHack/edit-gift?listId=<%= gift.getListId() %>&id=<%= gift.getId() %>" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
                                                        <a href="/GiftHack/delete-gift?listId=<%= gift.getListId() %>&id=<%= gift.getId() %>" class="on-default remove-row"><i class="fa fa-trash-o"></i></a>
                                                    </td>
                                                     <% } else { %>
                                                       <% if(gift.isReserved()) { %>
                                                          <% if(gift.getReservedBy()== userId) { %>
                                                          <td>
                                                            <a href="/GiftHack/release-gift?listId=<%= gift.getListId() %>&id=<%= gift.getId() %>" class="on-default edit-row"><i class="md md-lock-outline"></i></a>
                                                          </td>
                                                          <% } else { %>
                                                          <td>
                                                            <a href="" class="on-default edit-row"><i class="md md-lock-outline"></i></a>
                                                          </td>
                                                            <% } %>
                                                        <% } else { %>
                                                        <td>
                                                         <a href="/GiftHack/reserve-gift?listId=<%= gift.getListId() %>&id=<%= gift.getId() %>" class="on-default edit-row"><i class="md md-lock-open"></i></a>
                                                        </td>
                                                        <% } %>
                                                     <% } %>
                                            </tr>
                                            <% i++; %>
                                        <% } %>
                                    </tbody>
                            </table>
                    </div>
                <% } %>
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