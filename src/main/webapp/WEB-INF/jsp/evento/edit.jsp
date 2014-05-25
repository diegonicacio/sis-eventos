<form action="${linkTo[EventoController].update}" method="post">
	<div class="box">
		<%@include file="form.jsp"%>
		<div class="actions">
			<div class="actions">
				<a href="${linkTo[EventoController].index}" class="btn btn-default">Voltar</a>
				<button type="submit" class="btn btn-default" name="_method"
					value="PUT">Salvar</button>
			</div>
		</div>
	</div>
</form>