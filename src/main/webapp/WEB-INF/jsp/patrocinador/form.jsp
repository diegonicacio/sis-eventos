<fieldset <c:if test="${action == 'show'}">disabled</c:if>>
	<c:if test="${not empty patrocinador.id}">
		<input type="hidden" name="patrocinador.id" value="${patrocinador.id}" />
		<input type="hidden" name="evento.id" value="${evento.id}" />
	</c:if>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Nome:</label> <input type="text" class="form-control"
				name="patrocinador.nome"
				placeholder="Ex: Semana Interna da Computação"
				value="${patrocinador.nome}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Descricao:</label>
			<textarea class="form-control" rows="6" name="patrocinador.descricao">${patrocinador.descricao}</textarea>
		</div>
	</div>


</fieldset>

