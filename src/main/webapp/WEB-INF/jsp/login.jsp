<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html ng-app>
     <head>
          <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.min.css"/>
          <script type="text/javascript" src="resources/js/lib/jquery-1.8.2.min.js"></script>
          <script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
          <script type="text/javascript" src="resources/js/lib/angular.min.js"></script>
         <title>
               Health Check Login Page
          </title>
     </head>
	<body>
		<div class="hero-unit" style="min-width:900px">
			<h1>
				Health Check Center
			</h1>
			<p></p>
			<p>
				<a class="btn btn-primary btn-large ">Welcome</a>
			</p>
		</div>
		<br/>
		<br/>
		 <div style="margin:0 30% 0 30%;min-width:600px"  >
               <form:form method="POST" action="login" modelAttribute="user" >
                    <form:errors path="" element="div" />
                    <div class="control-group">
                         <label class="control-label" for="inputEmail">Email:</label>
                         <div class="controls">
                              <form:input path="id" style="height:25px" name="id"  type="email" id="inputEmail" placeholder="Email" required="true"/>
                         </div>
                    </div>
                    <div class="control-group">
                         <label class="control-label" for="inputPassword">Password:</label>
                         <div class="controls">
                              <form:password path="password" style="height:25px" name="password" id="inputPassword" placeholder="Password" required="true"/>
                         </div>
                    </div>

                    <div class="control-group">
                         <div class="controls">
                             <input type="submit" style="margin-left:120px" value="Sign in" class="btn" />
                         </div>
                    </div>
               </form:form>
          </div>
	</body>

</html>
<html>
