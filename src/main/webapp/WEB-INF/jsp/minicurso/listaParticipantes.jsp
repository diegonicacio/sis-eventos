<input type="hidden" name="minicurso.id" value="${minicurso.id}"/>
<div class="row">
	<!-- /.col-lg-12 -->
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Inscritos no minicurso :
				${minicurso.tema}</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Pagou?</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${participanteList}" var="participante">
								<tr>
									<td>${participante.nome}</td>
									<td><c:if test="${participante.pagou}">SIM</c:if> <c:if
											test="${!participante.pagou}">NAO</c:if></td>
									<td><a class="btn btn-default btn-sm"
										href="${linkTo[ParticipanteController].destroyMinicurso[evento][minicurso][participante]}"
										title="Deletar Inscrição"
										onclick="return confirm('Tem certeza que deseja cancelar a inscrição?')">
											<span class="glyphicon glyphicon-remove-sign"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.table-responsive -->
			</div>
		</div>
	</div>
</div>