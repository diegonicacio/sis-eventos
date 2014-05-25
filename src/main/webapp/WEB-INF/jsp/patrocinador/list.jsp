<div class="row">
	<!-- /.col-lg-12 -->
	<div class="col-lg-12">
		<div class="panel panel-default">
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
									<td><a class="btn btn-default btn-sm"
										href="${linkTo[PatrocinadorController].edit[evento][patrocinador]}"
										title="Editar Minicurso"> <span
											class="glyphicon glyphicon-pencil"></span>
									</a><a class="btn btn-default btn-sm" href="#"
										title="Ver lista de inscritos"> <span
											class="glyphicon glyphicon-search"></span>
									</a><a class="btn btn-default btn-sm"
										href="${linkTo[PatrocinadorController].destroy[evento][patrocinador]}"
										title="Excluir Minicurso"
										onclick="return confirm('Tem certeza que deseja excluir o patrocinador?')">
											<span class="glyphicon glyphicon-remove-sign"></span>
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