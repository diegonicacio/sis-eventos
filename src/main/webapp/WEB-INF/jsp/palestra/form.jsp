<fieldset <c:if test="${action == 'show'}">disabled</c:if>>
	<c:if test="${not empty palestra.id}">
		<input type="hidden" name="palestra.id" value="${palestra.id}" />
		<input type="hidden" name="evento.id" value="${evento.id}" />
	</c:if>

	<div class="row">
		<div class="form-group col-lg-8">
			<label>Tema:</label> <input type="text" class="form-control"
				name="palestra.tema"
				placeholder="Ex: Desenvolvimento de Aplicações Android"
				value="${palestra.tema}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Local:</label> <input type="text" class="form-control"
				name="palestra.local" placeholder="Ex: LAB 01 - FIPSI"
				value="${palestra.local}" />
		</div>
		<div class="form-group col-lg-4">
			<label>Palestrante:</label> <input type="text" class="form-control"
				name="palestra.palestrante" placeholder="Ex: Riquelme da Batera"
				value="${palestra.palestrante}" />
		</div>
	</div>

	<div class="row">

		<div class="form-group col-lg-2">
			<label>Data:</label>
			<div class="input-group date" id="datetimepicker5"
				data-date-format="DD/MM/YYYY">
				<input type="text" class="form-control"
					placeholder="<fmt:formatDate pattern="dd/MM/yyyy"
value="${palestra.dataInicio.time}" />"
					name=data value="${data}"> <span class="input-group-addon"><span
					class="glyphicon glyphicon-calendar"></span> </span>
			</div>
		</div>
		<div class="form-group col-lg-2">
			<label>Hora:</label>
			<div class='input-group date' id='datetimepicker4'>
				<input type='text' class="form-control"
					placeholder="<fmt:formatDate pattern="hh:mm a"
value="${palestra.dataInicio.time}" />"
					name=hora value="${hora}" /> <span class="input-group-addon"><span
					class="glyphicon glyphicon-time"></span> </span>
			</div>
		</div>
		<div class="form-group col-lg-2">
			<label>Preco:</label> <input type="text" class="form-control"
				name="palestra.precoMinicurso" placeholder="Ex: R$15,00"
				value="${palestra.precoMinicurso}" />
		</div>
		<div class="form-group col-lg-2">
			<label>Vagas:</label> <input type="text" class="form-control"
				name="palestra.vagas" placeholder="Ex: 50" value="${palestra.vagas}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-8">
			<label>Descricao:</label>
			<textarea class="form-control" rows="6" name="palestra.descricao">${palestra.descricao}</textarea>
		</div>
	</div>

	<div class="row">
		<a class="btn btn-primary btn-file"> Selecione o arquivo<input
			type="file" name="pl"
			<c:if test="${action == 'edit'}">disabled</c:if> />
		</a>
	</div>


</fieldset>

