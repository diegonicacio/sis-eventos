<div class="row">
	<input type="hidden" name="evento.id" value="${evento.id}" />
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
									<td><a class="btn btn-default btn-sm" href="#"
										title="Editar Minicurso"> <span
											class="glyphicon glyphicon-pencil"></span>
									</a><a class="btn btn-default btn-sm" href="#"
										title="Ver lista de inscritos"> <span
											class="glyphicon glyphicon-search"></span>
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

			<div class="panel-heading">Palestras</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>Tema</th>
								<th>Palestrante</th>
								<th>Vagas</th>
								<th>Preço</th>
								<th>Data - Hora</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${palestraList}" var="palestra">
								<tr>
									<td>${palestra.tema}</td>
									<td>${palestra.palestrante}</td>
									<td>${palestra.vagas}</td>
									<td>${palestra.precoMinicurso}</td>
									<td><fmt:formatDate type="both"
											value="${palestra.dataInicio.time}" /></td>
									<td><a class="btn btn-default btn-sm" href="#"
										title="Editar Minicurso"> <span
											class="glyphicon glyphicon-pencil"></span>
									</a><a class="btn btn-default btn-sm" href="#"
										title="Ver lista de inscritos"> <span
											class="glyphicon glyphicon-search"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.table-responsive -->
				<a class="btn btn-default btn-sm"
					href="${linkTo[PalestraController].newPalestra[evento]}"
					title="Adicionar Palestra"> <span
					class="glyphicon glyphicon-plus">Palestra</span>
				</a>
			</div>
			<div class="clearfix"></div>
			<hr>
			<div class="panel-heading">Patrocinadores</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Descricao</th>
								<th>Merchandising</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${patrocinadorList}" var="patrocinador">
								<tr>
									<td>${patrocinador.nome}</td>
									<td>${patrocinador.descricao}</td>
									<td>Baboseiras sobre a empresa</td>
									<td><a class="btn btn-default btn-sm" href="#"
										title="Editar Minicurso"> <span
											class="glyphicon glyphicon-pencil"></span>
									</a><a class="btn btn-default btn-sm" href="#"
										title="Ver lista de inscritos"> <span
											class="glyphicon glyphicon-search"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.table-responsive -->
					<a class="btn btn-default btn-sm"
					href="${linkTo[PatrocinadorController].newPatrocinador[evento]}"
					title="Adicionar Patrocinador"> <span
					class="glyphicon glyphicon-plus">Patrocinador</span>
				</a>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
</div>