<form action="${linkTo[UsuarioController].login}" method="post">
	<div class="box">
		<fieldset>
			<div class="row">
				<div class="form-group col-lg-2">
					<label>Login:</label> <input type="text" class="form-control"
						name="usuario.login" value="${usuario.login}" />
				</div>
			</div>

			<div class="row">
				<div class="form-group col-lg-2">
					<label>Senha:</label> <input type="password" class="form-control"
						name="usuario.senha" value="${usuario.senha}" />
				</div>
			</div>
		</fieldset>
		<div class="actions">
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</div>
</form>