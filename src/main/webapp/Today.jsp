<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<div class="col-md-12 grid-margin">
	<div class="row">
		<div class="col-12 col-xl-8 mb-4 mb-xl-0">
			<h6 class="font-weight-normal mb-0"></h6>
		</div>

		<%
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
		String formattedDate = currentDate.format(formatter);
		%>
		<div class="col-12 col-xl-4">
			<div class="justify-content-end d-flex">
				<div class="dropdown flex-md-grow-1 flex-xl-grow-0">
					<button class="btn btn-sm btn-light bg-white" type="button"
						aria-haspopup="true" aria-expanded="true">
						<i class="mdi mdi-calendar"></i> Today (<%=formattedDate%>)
					</button>
				</div>
			</div>
		</div>
	</div>
</div>