<div class="box">
	<c:forEach items="${minicursoList}" var="minicurso">
	<div class="row">
		<div class="col-md-7">
			<a> <img class="img-responsive" src="http://placehold.it/750x350">
			</a>
		</div>

		<div class="col-md-5">
			<h3>${minicurso.tema}</h3>
			<h5>
				<fmt:formatDate type="both" value="${minicurso.dataInicio.time}" /> | ${minicurso.local}
			</h5>
			<h1><small>R$: ${minicurso.precoMinicurso}</small></h1>
			<p>${minicurso.descricao}</p>
		</div>
	</div>
	<br>
	</c:forEach>
</div>