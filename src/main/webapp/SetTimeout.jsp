
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

<jsp:include page="AllCss.jsp"></jsp:include>
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

					<div class="col-md-4">
						<div class="card">
							<div class="card-body">

										<form action="SetTimeoutController" method="post" class="form">
		
											Time : <input type="Text" name="time" class="form-control" /><br>
											<Br> <input type="submit" class="btn btn-primary"  value="Change Timeout" />
										</form>
							</div>
						</div>
					</div>
				</div>





			</div>
			<!-- content-wrapper ends -->
			<!-- partial:partials/_footer.html -->
			<jsp:include page="AdminFooter.jsp"></jsp:include>
			<!-- partial -->
		</div>
		<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->


</body>
</html>