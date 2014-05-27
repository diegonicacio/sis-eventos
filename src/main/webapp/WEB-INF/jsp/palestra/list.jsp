<div class="row">
	<!-- /.col-lg-12 -->
	<div class="col-lg-12">
		<div class="panel panel-default">
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
									<td><a class="btn btn-default btn-sm"
										href="${linkTo[PalestraController].edit[evento][palestra]}"
										title="Editar Minicurso"> <span
											class="glyphicon glyphicon-pencil"></span>
									</a><a class="btn btn-default btn-sm"
										href="${linkTo[PalestraController].listaParticipantes[evento][palestra]}"
										title="Ver lista de inscritos"> <span
											class="glyphicon glyphicon-search"></span>
									</a><a class="btn btn-default btn-sm"
										href="${linkTo[PalestraController].destroy[evento][palestra]}"
										title="Excluir Minicurso"
										onclick="return confirm('Tem certeza que deseja excluir o palestra?')">
											<span class="glyphicon glyphicon-remove-sign"></span>
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
		</div>
	</div>
</div>