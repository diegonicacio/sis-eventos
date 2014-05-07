<form action="${linkTo[PalestraController].create}" method="post">
	<input type="hidden" name="evento.id" value="${evento.id}" />
	<div class="box">
		<%@include file="form.jsp"%>
		<div class="actions">
			<a href="${linkTo[EventoController].gerenciaEvento[evento]}" class="btn btn-default">Voltar</a> <input type="submit"
				class="btn btn-default" value="Salvar">
		</div>
	</div>
</form>