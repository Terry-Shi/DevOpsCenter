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
		 <div style="margin:0 30% 0 30%;min-width:600px" ng-controller="LoginCtrl" >
               <form:form method="POST"  action="login" commandName="user" class="form-horizontal" name="form" >
                    <div class="control-group">
                         <label class="control-label" for="inputEmail">Email:</label>
                         <div class="controls">
                              <form:input path="email" style="height:25px" name="email" ng-model="login.email" ng-disabled="role == 'guest'" type="email" id="inputEmail" placeholder="Email" required="true"/>
                           <span ng-style="{color:'red'}" ng-show="form.email.$dirty&&form.email.$error.email">Invalid email!</span>
                           <span ng-style="{color:'red'}" ng-show="form.email.$dirty&&form.email.$error.required">Mandatory!</span>
                         </div>
                    </div>
                    <div class="control-group">
                         <label class="control-label" for="inputPassword">Password:</label>
                         <div class="controls">
                              <form:password path="password" style="height:25px" name="passwd" ng-model="login.passwd" ng-disabled="role == 'guest'" id="inputPassword" placeholder="Password" required="true"/>
                              <span ng-style="{color:'red'}" ng-show="form.passwd.$dirty&&form.passwd.$error.required">Please input your passwd!</span>
                         </div>
                    </div>
                    <div class="control-group form-inline" style="margin-left:180px">
                         <label class="radio" style="margin-right:25px">
                            <form:radiobutton path="role" value="user" ng-model="role" ng-checked="true" ng-change="changeRole()" /> User
                         </label>
                         <label class="radio">
                            <form:radiobutton path="role" value="guest" ng-model="role" ng-change="changeRole()"/> Guest
                         </label>
                    </div>
                    <div class="control-group">
                         <div class="controls">
                             <input type="submit" style="margin-left:120px" value="Sign in" class="btn" />
                         </div>
                    </div>
               </form:form>
          </div>
	</body>
	<script type="text/javascript">
    var LoginCtrl = function($scope){
      $scope.role;
      $scope.login;
      $scope.guest = {
        'email' : "guest@hp.com",
        'passwd': "changeit"
      };
      $scope.changeRole = function(){
        if($scope.role == "user"){
          $scope.login = {};
        }else{
          $scope.login = angular.copy($scope.guest);
        }
      };
		}
	</script>
</html>
<html>
