<form action="${linkTo[PalestraController].create}" method="post" enctype="multipart/form-data">
	<input type="hidden" name="evento.id" value="${evento.id}" />
	<div class="box">
		<%@include file="form.jsp"%>
		<div class="actions">
			<a href="${linkTo[PalestraController].list[evento]}"
				class="btn btn-default">Voltar</a> <input type="submit"
				class="btn btn-default" value="Salvar">
		</div>
	</div>
</form>