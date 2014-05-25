<form action="${linkTo[EventoController].create}" method="post">
	<div class="box">
		<%@include file="form.jsp"%>
		<div class="actions">
			<a href="${linkTo[EventoController].index}" class="btn btn-default">Voltar</a>
			<input type="submit" class="btn btn-default" value="Salvar">
		</div>
	</div>
</form>