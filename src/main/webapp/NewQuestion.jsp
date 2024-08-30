<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

</head>
<body>

	<!-- partial:partials/_navbar.html -->
	<jsp:include page="AdminHeader.jsp"></jsp:include>
	<!-- partial -->
	<div class="container-fluid page-body-wrapper">
		<!-- partial:partials/_sidebar.html -->
		<jsp:include page="AdminSidebar.jsp"></jsp:include>
		<!-- partial -->
		<div class="main-panel">
			<div class="content-wrapper">
				<div class="row">
					<jsp:include page="Today.jsp"></jsp:include>
				</div>



				<div class="row">
					<div class="col-md-12 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title">Add Question</h4>
 								<form class="forms-sample" action="SaveQuestionController" method="post">
									<div class="form-group">
										<label for="exampleInputUsername1">Username</label> <input
											type="text" class="form-control" id="exampleInputUsername1"
											placeholder="Username">
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Email address</label> <input
											type="email" class="form-control" id="exampleInputEmail1"
											placeholder="Email">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Password</label> <input
											type="password" class="form-control"
											id="exampleInputPassword1" placeholder="Password">
									</div>
									<div class="form-group">
										<label for="exampleInputConfirmPassword1">Confirm
											Password</label> <input type="password" class="form-control"
											id="exampleInputConfirmPassword1" placeholder="Password">
									</div>
								 
									<button type="submit" class="btn btn-primary me-2">Save Question</button>
									<a class="btn btn-light" href="AdminHome.jsp">Cancel</a>
								</form>
							</div>
						</div>
					</div>
				</div>



			</div>
			<!-- content-wrapper ends -->
			<!-- partial:partials/_footer.html -->
			<footer class="footer">

				<div class="justify-content-center justify-content-sm-between">
					<center>
						<span
							class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright
							&copy; 2024 Tejas Shah </span>
					</center>
				</div>

			</footer>
			<!-- partial -->
		</div>
		<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="assets/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page -->
	<script src="assets/vendors/chart.js/chart.umd.js"></script>
	<script src="assets/vendors/datatables.net/jquery.dataTables.js"></script>
	<!-- <script src="assets/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script> -->
	<script
		src="assets/vendors/datatables.net-bs5/dataTables.bootstrap5.js"></script>
	<script src="assets/js/dataTables.select.min.js"></script>
	<!-- End plugin js for this page -->
	<!-- inject:js -->
	<script src="assets/js/off-canvas.js"></script>
	<script src="assets/js/template.js"></script>
	<script src="assets/js/settings.js"></script>
	<script src="assets/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="assets/js/jquery.cookie.js" type="text/javascript"></script>
	<script src="assets/js/dashboard.js"></script>
	<!-- <script src="assets/js/Chart.roundedBarCharts.js"></script> -->
	<!-- End custom js for this page-->
</body>
</html>