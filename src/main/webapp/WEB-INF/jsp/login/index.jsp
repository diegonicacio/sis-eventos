<div class="box">
	<div class="col-lg-12">



		<form action="${linkTo[OrganizadorController].auth}" method="post" >

			<div class="form-group col-lg-4">
				<label>Login</label> <input type="text"  class="form-control"
					name="organizador.login">
					<label>Password</label> <input type="password" class="form-control"
					name="organizador.senha">
					<input type="hidden" name="submit" value="contact">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>

		</form>

	</div>
</div>
