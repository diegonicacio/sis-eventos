<div class="box">
	<c:forEach items="${minicursoList}" var="minicurso">
	<div class="row">
		<div class="col-md-7">
			<a> <c:if test="${!minicurso.capa}"> <img class="img-responsive" src="http://placehold.it/750x350"></c:if>
			<c:if test="${minicurso.capa}"> <img class="img-responsive" src="${pageContext.request.contextPath}/arquivos/${minicurso.id}mc.jpg"></c:if>
			</a>
		</div>

		<div class="col-md-5">
			<h3>${minicurso.tema}</h3>
			<h5>
				<fmt:formatDate type="both" value="${minicurso.dataInicio.time}" />
					| ${minicurso.local} <br> <br> ${minicurso.palestrante}
				</h5>
			<h1><small>R$: ${minicurso.precoMinicurso}</small></h1>
			<p>${minicurso.descricao}</p>
		</div>
	</div>
	<br>
	</c:forEach>
</div>