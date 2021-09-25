<%@page import="data.Gift"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.GiftList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    ArrayList<GiftList> giftLists = (ArrayList<GiftList>)request.getAttribute("lists");
    ArrayList<Gift> gifts = (ArrayList<Gift>)request.getAttribute("gifts");
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
                                <li><a href="#" class="waves-effect waves-light">Shop For</a></li>
                            </ul>
                            
<!--                             <ul class="nav navbar-nav hidden-xs">
                                <li><a href="#" class="waves-effect waves-light">Groups</a></li>
                            </ul>-->

<!--                            <form role="search" class="navbar-left app-search pull-left hidden-xs">
			                     <input type="text" placeholder="Find a memeber..." class="form-control">
			                     <a href=""><i class="fa fa-search"></i></a>
			                </form>-->


                            <ul class="nav navbar-nav navbar-right pull-right">
                                <li class="dropdown top-menu-item-xs">
                                    <a href="#" data-target="#" class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="true">
                                        <i class="icon-bell"></i>
<!--                                        <span class="badge badge-xs badge-danger">3</span>-->
                                    </a>
<!--                                    <ul class="dropdown-menu dropdown-menu-lg">
                                        <li class="notifi-title">
                                            <span class="label label-default pull-right">New 3</span>
                                            Notification</li>
                                        <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 230px;"><li class="list-group slimscroll-noti notification-list" style="overflow: hidden; width: auto; height: 230px;">
                                            list item
                                           <a href="javascript:javascript:void(0);" class="list-group-item"></a>                                          
                                              <span class="label label-default pull-right">New 3</span>
                                              <div class="media">
                                                 <div class="pull-left p-r-10">
                                                    <em class="fa fa-diamond noti-primary"></em>
                                                 </div>
                                                 <div class="media-body">
                                                    <h5 class="media-heading">A new order has been placed A new order has been placed</h5>
                                                    <p class="m-0">
                                                        <small>There are new settings available</small>
                                                    </p>
                                                 </div>
                                              </div>
                                           </a>

                                            list item
                                           <a href="javascript:void(0);" class="list-group-item">
                                              <div class="media">
                                                 <div class="pull-left p-r-10">
                                                    <em class="fa fa-cog noti-warning"></em>
                                                 </div>
                                                 <div class="media-body">
                                                    <h5 class="media-heading">New settings</h5>
                                                    <p class="m-0">
                                                        <small>There are new settings available</small>
                                                    </p>
                                                 </div>
                                              </div>
                                           </a>

                                            list item
                                           <a href="javascript:void(0);" class="list-group-item">
                                              <div class="media">
                                                 <div class="pull-left p-r-10">
                                                    <em class="fa fa-bell-o noti-custom"></em>
                                                 </div>
                                                 <div class="media-body">
                                                    <h5 class="media-heading">Updates</h5>
                                                    <p class="m-0">
                                                        <small>There are <span class="text-primary font-600">2</span> new updates available</small>
                                                    </p>
                                                 </div>
                                              </div>
                                           </a>

                                            list item
                                           <a href="javascript:void(0);" class="list-group-item">
                                              <div class="media">
                                                 <div class="pull-left p-r-10">
                                                    <em class="fa fa-user-plus noti-pink"></em>
                                                 </div>
                                                 <div class="media-body">
                                                    <h5 class="media-heading">New user registered</h5>
                                                    <p class="m-0">
                                                        <small>You have 10 unread messages</small>
                                                    </p>
                                                 </div>
                                              </div>
                                           </a>

                                             list item
                                           <a href="javascript:void(0);" class="list-group-item">
                                              <div class="media">
                                                 <div class="pull-left p-r-10">
                                                    <em class="fa fa-diamond noti-primary"></em>
                                                 </div>
                                                 <div class="media-body">
                                                    <h5 class="media-heading">A new order has been placed A new order has been placed</h5>
                                                    <p class="m-0">
                                                        <small>There are new settings available</small>
                                                    </p>
                                                 </div>
                                              </div>
                                           </a>

                                            list item
                                           <a href="javascript:void(0);" class="list-group-item">
                                              <div class="media">
                                                 <div class="pull-left p-r-10">
                                                    <em class="fa fa-cog noti-warning"></em>
                                                 </div>
                                                 <div class="media-body">
                                                    <h5 class="media-heading">New settings</h5>
                                                    <p class="m-0">
                                                        <small>There are new settings available</small>
                                                    </p>
                                                 </div>
                                              </div>
                                           </a>
                                        </li><div class="slimScrollBar" style="background: rgb(152, 166, 173); width: 5px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px;"></div><div class="slimScrollRail" style="width: 5px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div></div>
                                        <li>
                                            <a href="javascript:void(0);" class="list-group-item text-right">
                                                <small class="font-600">See all notifications</small>
                                            </a>
                                        </li>
                                    </ul>-->
                                </li>
                                <li class="dropdown top-menu-item-xs">
                                    <a href="" class="dropdown-toggle profile waves-effect waves-light" data-toggle="dropdown" aria-expanded="true"><img src="assets/images/users/avatar-1.jpg" alt="user-img" class="img-circle"> </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="javascript:void(0)"><i class="ti-user m-r-10 text-custom"></i> Profile</a></li>
                                        <li><a href="javascript:void(0)"><i class="ti-settings m-r-10 text-custom"></i> Settings</a></li>
                                        <li class="divider"></li>
                                        <li><a href="/GiftHack/login?logout=1"><i class="ti-power-off m-r-10 text-danger"></i> Logout</a></li>
                                    </ul>
                                </li>
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
                                                    <td>
                                                        <a href="/GiftHack/edit-gift?listId=<%= gift.getListId() %>&id=<%= gift.getId() %>" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
                                                        <a href="/GiftHack/delete-gift?listId=<%= gift.getListId() %>&id=<%= gift.getId() %>" class="on-default remove-row"><i class="fa fa-trash-o"></i></a>
                                                    </td>
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