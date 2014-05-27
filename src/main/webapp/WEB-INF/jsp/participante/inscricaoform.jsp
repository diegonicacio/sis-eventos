<fieldset <c:if test="${action == 'show'}">disabled</c:if>>
	<c:if test="${not empty evento.id}">
		<input type="hidden" name="evento.id" value="${evento.id}" />
	</c:if>

	<div class="row">
		<div class="form-group col-lg-8">
			<label>Nome:</label> <input type="text" class="form-control"
				name="participante.nome" placeholder="Ex: Diego Nicacio de Carvalho"
				value="${participante.nome}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Profissão:</label> <input type="text" class="form-control"
				name="participante.ocupacao" placeholder="Ex: Estudante"
				value="${participante.ocupacao}" />
		</div>
		<div class="form-group col-lg-4">
			<label>RG:</label> <input type="text" class="form-control"
				name="participante.rg" placeholder="Ex: 3086429"
				value="${participante.rg}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-8">
			<c:forEach items="${minicursoList}" var="minicurso" varStatus="s">
				<input type="checkbox" name="minicursoList[${s.index}].id"
					value="${minicurso.id}" />${minicurso.tema}
				<br>
			</c:forEach>
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-8">
			<c:forEach items="${palestraList}" var="palestra" varStatus="p">
				<input type="checkbox" name="palestraList[${p.index}].id"
					value="${palestra.id}" />${palestra.tema}
				<br>
			</c:forEach>
		</div>
	</div>


</fieldset>
