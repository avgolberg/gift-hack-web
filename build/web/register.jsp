<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%     
    String registrationInfo = (String) request.getAttribute("registration");
    
    boolean usedUsername = false;
    if(registrationInfo!=null) usedUsername = true;
    
    String name = (String) request.getAttribute("name");
    String surname = (String) request.getAttribute("surname");
    String email = (String) request.getAttribute("email");
    String birthday = (String) request.getAttribute("birthday");
%>
<!DOCTYPE html>
<html>
	<head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <link rel="shortcut icon" href="assets/images/favicon_1.ico">

            <title>GiftHack | Register</title>

        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/core.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/components.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/pages.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/responsive.css" rel="stylesheet" type="text/css" />
        <script src="assets/js/modernizr.min.js"></script>

	</head>
	<body>

		<div class="account-pages"></div>
		<div class="clearfix"></div>
		<div class="wrapper-page">
			<div class="card-box">
                            <div class="panel-heading">
                                    <h3 class="text-center"> Sign Up to <strong class="text-custom">GiftHack</strong> </h3>
                            </div>

                                <form data-parsley-validate="" novalidate="" class="form-horizontal m-t-20" action="<%=request.getContextPath()%>/register" method="post">
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <input type="text" parsley-trigger="change" required="" placeholder="Username" class="form-control" id="username" name="username">
                                            </div>                                        
                                        </div>
                                       
                                         <div class="form-group">
                                            <div class="col-xs-12">   
                                                <% if(usedUsername) { %>
                                             <input type="text" parsley-trigger="change" required="" placeholder="Name" class="form-control" id="name" name="name" value="<%= name %>">
                                                <%} else{%>
                                                <input type="text" parsley-trigger="change" required="" placeholder="Name" class="form-control" id="name" name="name">
                                                <%}%>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12"> 
                                                 <% if(usedUsername) { %>
                                                <input type="text" parsley-trigger="change" required="" placeholder="Surname" class="form-control" id="surname" name="surname" value="<%= surname %>">
                                                 <%} else{%>
                                                <input type="text" parsley-trigger="change" required="" placeholder="Surname" class="form-control" id="surname" name="surname">
                                                 <%}%>
                                            </div> 
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12"> 
                                                <% if(usedUsername) { %>
                                                <input type="email" parsley-trigger="change" required="" placeholder="Email" class="form-control" id="email" name="email" value="<%= email %>">
                                                <%} else{%>
                                                <input type="email" parsley-trigger="change" required="" placeholder="Email" class="form-control" id="email" name="email">
                                                <%}%>
                                            </div> 
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12"> 
                                                 <% if(usedUsername) { %>
                                                <input type="text" value="<%= birthday %>" parsley-trigger="change" required="" class="form-control" placeholder="Birthday" id="datepicker-autoclose" name="birthday" onfocusin="(this.type='date')" onfocusout="(this.type='text')">
                                                <%} else{%>
                                                 <input type="text" parsley-trigger="change" required="" class="form-control" placeholder="Birthday" id="datepicker-autoclose" name="birthday" onfocusin="(this.type='date')" onfocusout="(this.type='text')">
                                                <%}%>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                             <div class="col-xs-12"> 
                                                <input id="pass1" type="password" placeholder="Password" required="" class="form-control" name="password">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12"> 
                                                <input data-parsley-equalto="#pass1" type="password" required="" placeholder="Confirm Password" class="form-control" id="passWord2">
                                            </div>
                                        </div>
                                        <div class="form-group text-center m-t-40">
                                                <div class="col-xs-12">
                                                        <button class="btn btn-info btn-block text-uppercase waves-effect waves-light" type="submit">
                                                                Register
                                                        </button>
                                                </div>
                                        </div>
                                </form>
                        </div>       

			<div class="row">
				<div class="col-sm-12 text-center">
					<p>
						Already have an account?<a href="/GiftHack/" class="text-primary m-l-5"><b>Sign In</b></a>
					</p>
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
             <% if(usedUsername) { %>
              $.Notification.autoHideNotify('warning', 'top center', '<%= registrationInfo %>','');
             <% } %>
         </script>
	</body>
</html>