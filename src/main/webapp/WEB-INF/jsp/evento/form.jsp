<fieldset <c:if test="${action == 'show'}">disabled</c:if>>
	<c:if test="${not empty evento.id}">
		<input type="hidden" name="evento.id" value="${evento.id}" />
	</c:if>

	<div class="row">
		<div class="form-group col-lg-8">
			<label>Nome:</label> <input type="text" class="form-control"
				name="evento.nome"
				placeholder="Ex: Semana Interna de Tecnologia e Integração 2014"
				value="${evento.nome}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Abreviacao:</label> <input type="text" class="form-control"
				name="evento.abreviacao" placeholder="Ex: SITI - 2014"
				value="${evento.abreviacao}" />
		</div>
		<div class="form-group col-lg-4">
			<label>Local:</label> <input type="text" class="form-control"
				name="evento.local" placeholder="Ex: Salão de Eventos - Hotel JK"
				value="${evento.local}" />
		</div>
	</div>

	<div class="row">

		<div class="form-group col-lg-2">
			<label>Data:</label>
			<div class="input-group date" id="datetimepicker5"
				data-date-format="DD/MM/YYYY">
				<input type="text" class="form-control"
					placeholder="<fmt:formatDate pattern="dd/MM/yyyy"
value="${evento.dataInicio.time}" />"
					name=data value="${data}"> <span class="input-group-addon"><span
					class="glyphicon glyphicon-calendar"></span> </span>
			</div>
		</div>
		<div class="form-group col-lg-2">
			<label>Hora:</label>
			<div class='input-group date' id='datetimepicker4'>
				<input type='text' class="form-control"
					placeholder="<fmt:formatDate pattern="hh:mm a"
value="${evento.dataInicio.time}" />"
					name=hora value="${hora}" /> <span class="input-group-addon"><span
					class="glyphicon glyphicon-time"></span> </span>
			</div>
		</div>
		<div class="form-group col-lg-2">
			<label>Preco:</label> <input type="text" class="form-control"
				name="evento.preco" placeholder="Ex: R$15,00"
				value="${evento.preco}" />
		</div>
		<div class="form-group col-lg-2">
			<label>Vagas:</label> <input type="text" class="form-control"
				name="evento.vagas" placeholder="Ex: 50" value="${evento.vagas}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-8">
			<label>Descricao:</label>
			<textarea class="form-control" rows="6" name="evento.descricao"
				placeholder="Aqui é interessante se colocar uma descrição de até 3 linhas por questões de estetica, porem nada impede que sejam adicionados mais informações, o sistema redimensionará automaticamente a caixa de texto e vai ficar show.">${evento.descricao}</textarea>
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-8">
			<label>Descricao 2:</label>
			<textarea class="form-control" rows="6" name="evento.descricao2"
				placeholder="Aqui é interessante se colocar uma descrição de até 5 linhas por questões de estetica, porem nada impede que sejam adicionados mais informações, o sistema redimensionará automaticamente a caixa de texto e vai ficar show.">${evento.descricao2}</textarea>
		</div>
	</div>

	<div class="row">
		<a class="btn btn-primary btn-file"> Selecione o arquivo<input
			type="file" name="files[]" />
		</a> <a class="btn btn-primary btn-file"> Selecione o arquivo<input
			type="file" name="files[]" />
		</a>
	</div>





</fieldset>
