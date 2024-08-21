<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Skydash Admin</title>
<!-- plugins:css -->
<link rel="stylesheet" href="assets/vendors/feather/feather.css">
<link rel="stylesheet"
	href="assets/vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="assets/vendors/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="assets/vendors/mdi/css/materialdesignicons.min.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="assets/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="assets/images/favicon.png" />
</head>
<body>
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div class="content-wrapper d-flex align-items-center auth px-0">
				<div class="row w-100 mx-0">
					<div class="col-lg-4 mx-auto">
						<div class="auth-form-light text-left py-5 px-4 px-sm-5">
							<div class="brand-logo">
								<img src="assets/images/logo.svg" alt="logo">
							</div>
							<h4>New here?</h4>
							<h6 class="font-weight-light">Signing up is easy. It only
								takes a few steps</h6>
							<form action="SignupController" method="post" class="pt-3">
								<div class="form-group">
									<input type="text" class="form-control form-control-lg"
										id="exampleInputUsername1" placeholder="Firstname"
										name="firstName" value="${user.firstName}"> <span class="text-danger">${firstNameError }</span>

								</div>

								<div class="form-group">
									<input type="text" class="form-control form-control-lg"
										id="exampleInputUsername1" placeholder="Lastname"
										name="lastName" value="${user.lastName}"> <span class="text-danger">${lastNameError }</span>
								</div>

								<div class="form-group">
									<input type="email" class="form-control form-control-lg"
										id="exampleInputEmail1" placeholder="Email" name="email" value="${user.email}">
									<span class="text-danger" >${emailError }</span>
								</div>

								<div class="form-group">
									<input type="password" class="form-control form-control-lg"
										id="exampleInputPassword1" placeholder="Password"
										name="password" value="${user.password}"> 
										<span class="text-danger">${passwordError }</span>

								</div>

								<div class="form-group">
									<select class="form-select form-select-lg"
										id="exampleFormControlSelect2" name="gender">
										<option value="">Select Gender</option>

										<option value="Male">Male</option>
										<option value="Female">Female</option>
										<option value="Other">Other</option>
									</select>
									<span class="text-danger">${genderError }</span>
									
								</div>

								<div class="form-group">
									<select class="form-select form-select-lg"
										id="exampleFormControlSelect2" name="city">
										<option value="">Select City</option>

										<option value="Surat" ${user.city.equals("surat")?"selected":"" }>Surat</option>
										<option value="Baroda">Baroda</option>
										<option value="Ahmedabad">Ahmedabad</option>
										<option value="Gandhinagar">Gandhinagar</option>
										<option value="Himmatnagar">HimmatNagar</option>

									</select>
									<span class="text-danger">${cityError }</span>
									
								</div>

								<div class="form-group">
									<input type="text" class="form-control form-control-lg"
										id="exampleInputEmail1" placeholder="Contactnum"
										name="contactNum" value="${user.contactNum}">
										<span class="text-danger">${contactNumError }</span>
										
								</div>

								<!-- <div class="mb-4">
									<div class="form-check">
										<label class="form-check-label text-muted"> <input
											type="checkbox" class="form-check-input"> I agree to
											all Terms & Conditions
										</label>
									</div>
								</div> -->
								<div class="mt-3 d-grid gap-2">
									<button
										class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn"
										type="submit">SIGN UP</button>
								</div>
								<div class="text-center mt-4 font-weight-light">
									Already have an account? <a href="Login.jsp"
										class="text-primary">Login</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- content-wrapper ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="assets/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page -->
	<!-- End plugin js for this page -->
	<!-- inject:js -->
	<script src="assets/js/off-canvas.js"></script>
	<script src="assets/js/template.js"></script>
	<script src="assets/js/settings.js"></script>
	<script src="assets/js/todolist.js"></script>
	<!-- endinject -->
</body>
</html>