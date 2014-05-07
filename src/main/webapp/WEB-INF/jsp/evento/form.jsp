<fieldset <c:if test="${action == 'show'}">disabled</c:if>>
	<c:if test="${not empty evento.id}">
		<input type="hidden" name="evento.id" value="${evento.id}" />
	</c:if>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Nome:</label> <input type="text" class="form-control"
				name="evento.nome" placeholder="Ex: Semana Interna da Computação"
				value="${evento.nome}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<div id="datetimepicker" class="input-append date">
				<input type="text"></input> <span class="add-on"> <i
					data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
				</span>
			</div>
			<script type="text/javascript">
				$('#datetimepicker').datetimepicker({
					format : 'dd/MM/yyyy hh:mm:ss',
					language : 'pt-BR'
				});
			</script>
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Local:</label> <input type="text" class="form-control"
				name="evento.local" placeholder="Ex: Salão de Eventos - Hotel JK"
				value="${evento.local}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Preco:</label> <input type="text" class="form-control"
				name="evento.preco" placeholder="Ex: R$15,00"
				value="${evento.preco}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Quantidade de vagas:</label> <input type="text"
				class="form-control" name="evento.vagas" placeholder="Ex: 50"
				value="${evento.vagas}" />
		</div>
	</div>

	<div class="form-group col-lg-4">
		<label>Descricao:</label>
		<textarea class="form-control" rows="6" name="evento.descricao">${evento.descricao}</textarea>
	</div>


</fieldset>

