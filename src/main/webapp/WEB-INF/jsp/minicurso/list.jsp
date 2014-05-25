<div class="row">
	<!-- /.col-lg-12 -->
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Minicursos</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Palestrante</th>
								<th>Vagas</th>
								<th>Preço</th>
								<th>Data - Hora</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${minicursoList}" var="minicurso">
								<tr>
									<td>${minicurso.tema}</td>
									<td>${minicurso.palestrante}</td>
									<td>${minicurso.vagas}</td>
									<td>${minicurso.precoMinicurso}</td>
									<td><fmt:formatDate type="both"
											value="${minicurso.dataInicio.time}" /></td>
									<td><a class="btn btn-default btn-sm"
										href="${linkTo[MinicursoController].edit[evento][minicurso]}"
										title="Editar Minicurso"> <span
											class="glyphicon glyphicon-pencil"></span>
									</a><a class="btn btn-default btn-sm"
										href="${linkTo[MinicursoController].listaParticipantes[evento][minicurso]}"
										title="Ver lista de inscritos"> <span
											class="glyphicon glyphicon-search"></span>
									</a><a class="btn btn-default btn-sm"
										href="${linkTo[MinicursoController].destroy[evento][minicurso]}"
										title="Excluir Minicurso"
										onclick="return confirm('Tem certeza que deseja excluir o minicurso?')">
											<span class="glyphicon glyphicon-remove-sign"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.table-responsive -->
				<a class="btn btn-default btn-sm"
					href="${linkTo[MinicursoController].newMinicurso[evento]}"
					title="Adicionar Minicurso"> <span
					class="glyphicon glyphicon-plus">Minicurso</span>
				</a>
			</div>
		</div>
	</div>
</div>