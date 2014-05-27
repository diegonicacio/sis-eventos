<fieldset <c:if test="${action == 'show'}">disabled</c:if>>
	<c:if test="${not empty minicurso.id}">
		<input type="hidden" name="minicurso.id" value="${minicurso.id}" />
		<input type="hidden" name="evento.id" value="${evento.id}" />
	</c:if>

	<div class="row">
		<div class="form-group col-lg-8">
			<label>Tema:</label> <input type="text" class="form-control"
				name="minicurso.tema"
				placeholder="Ex: Desenvolvimento de Aplicações Android"
				value="${minicurso.tema}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Local:</label> <input type="text" class="form-control"
				name="minicurso.local" placeholder="Ex: LAB 01 - FIPSI"
				value="${minicurso.local}" />
		</div>
		<div class="form-group col-lg-4">
			<label>Palestrante:</label> <input type="text" class="form-control"
				name="minicurso.palestrante" placeholder="Ex: Riquelme da Batera"
				value="${minicurso.palestrante}" />
		</div>
	</div>

	<div class="row">

		<div class="form-group col-lg-2">
			<label>Data:</label>
			<div class="input-group date" id="datetimepicker5"
				data-date-format="DD/MM/YYYY">
				<input type="text" class="form-control"
					placeholder="<fmt:formatDate pattern="dd/MM/yyyy"
value="${minicurso.dataInicio.time}" />"
					name=data value="${data}"> <span class="input-group-addon"><span
					class="glyphicon glyphicon-calendar"></span> </span>
			</div>
		</div>
		<div class="form-group col-lg-2">
			<label>Hora:</label>
			<div class='input-group date' id='datetimepicker4'>
				<input type='text' class="form-control"
					placeholder="<fmt:formatDate pattern="hh:mm a"
value="${minicurso.dataInicio.time}" />"
					name=hora value="${hora}" /> <span class="input-group-addon"><span
					class="glyphicon glyphicon-time"></span> </span>
			</div>
		</div>
		<div class="form-group col-lg-2">
			<label>Preco:</label> <input type="text" class="form-control"
				name="minicurso.precoMinicurso" placeholder="Ex: R$15,00"
				value="${minicurso.precoMinicurso}" />
		</div>
		<div class="form-group col-lg-2">
			<label>Vagas:</label> <input type="text" class="form-control"
				name="minicurso.vagas" placeholder="Ex: 50"
				value="${minicurso.vagas}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-8">
			<label>Descricao:</label>
			<textarea class="form-control" rows="6" name="minicurso.descricao"
				placeholder="Aqui é interessante se colocar uma descrição de até 3 linhas por questões de estetica, porem nada impede que sejam adicionados mais informações, o sistema redimensionará automaticamente a caixa de texto e vai ficar show.">${minicurso.descricao}</textarea>
		</div>
	</div>

	<div class="row">
		<a class="btn btn-primary btn-file"> Selecione o arquivo<input
			type="file" name="mc"
			<c:if test="${action == 'edit'}">disabled</c:if> />
		</a>
	</div>


</fieldset>

