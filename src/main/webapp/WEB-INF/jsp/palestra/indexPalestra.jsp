<div class="box">
	<c:forEach items="${palestraList}" var="palestra">
	<div class="row">
		<div class="col-md-7">
			<a> <c:if test="${!palestra.capa}"> <img class="img-responsive" src="http://placehold.it/750x350"></c:if>
			<c:if test="${palestra.capa}"> <img class="img-responsive" src="${pageContext.request.contextPath}/arquivos/${palestra.id}pl.jpg"></c:if>
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