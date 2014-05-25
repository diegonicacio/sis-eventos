<div class="brand">Flango 2014</div>
<div class="address-bar">Sistema Gerenciador de Eventos</div>

<nav class="navbar navbar-default" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Business Casual</a>
		</div>
<input type="hidden" name="evento.id" value="${evento.id}" />
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li><a href="${linkTo[MinicursoController].list[evento]}">Minicursos</a></li>
				<li><a href="${linkTo[PalestraController].list[evento]}">Palestras</a></li>
				<li><a href="${linkTo[PatrocinadorController].list[evento]}">Patrocinadores</a></li>
				<li><a href="#">Miscellaneous</a></li>
				<li><a href="#"><small>Logout</small></a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>