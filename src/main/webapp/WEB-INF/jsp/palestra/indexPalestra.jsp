<div class="box">
	<c:forEach items="${palestraList}" var="minicurso">
	<div class="row">
		<div class="col-md-7">
			<a> <img class="img-responsive" src="http://placehold.it/750x350">
			</a>
		</div>

		<div class="col-md-5">
			<h3>${palestra.tema}</h3>
			<h5>
				<fmt:formatDate type="both" value="${palestra.dataInicio.time}" /> | ${palestra.local}
			</h5>
			<h1><small>R$: ${palestra.precoMinicurso}</small></h1>
			<p>${palestra.descricao}</p>
		</div>
	</div>
	<br>
	</c:forEach>
</div>