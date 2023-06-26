  <%@ include file="/init.jsp"%>
<%-- <%@ include file="/js/main.js" %> --%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>DG Food</title>

</head>
<body>
	<section id="home" class="pb-5">

		<div style="background-color: #346602"
			class="text-light position-relative">
			<div class="container d-flex">
				<div class="d-flex align-items-center"
					style="background-color: #87c452">
					<i class="bi bi-card-text fs-5 px-3"></i>
				</div>
				<div class="w-100 py-2">
					<div
						class="marquee d-flex align-items-center border-end border-light">
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Magni repellat fugiat quo alias facilis necessitatibus. Minima
							officia nobis at, possimus itaque nemo et vitae quod nihil quo
							quaerat natus ut eos reprehenderit sequi expedita sed dignissimos
							explicabo consectetur doloremque veritatis blanditiis fugit
							molestias incidunt! Eos esse ad odio maiores ullam harum repellat
							earum libero? Labore eius voluptates sed impedit illum excepturi
							nobis! Enim autem tempora minus modi natus commodi repudiandae
							totam facere vitae, similique rem neque soluta delectus
							reprehenderit asperiores quia consectetur placeat eos maiores
							amet odit ad molestias nihil. Nobis amet dolore consectetur
							ipsam, tempora quo quidem expedita inventore. Lorem ipsum dolor
							sit amet, consectetur adipisicing elit. Magni repellat fugiat quo
							alias facilis necessitatibus. Minima officia nobis at, possimus
							itaque nemo et vitae quod nihil quo quaerat natus ut eos
							reprehenderit sequi expedita sed dignissimos explicabo
							consectetur doloremque veritatis blanditiis fugit molestias
							incidunt! Eos esse ad odio maiores ullam harum repellat earum
							libero? Labore eius voluptates sed impedit illum excepturi nobis!
							Enim autem tempora minus modi natus commodi repudiandae totam
							facere vitae, similique rem neque soluta delectus reprehenderit
							asperiores quia consectetur placeat eos maiores amet odit ad
							molestias nihil. Nobis amet dolore consectetur ipsam, tempora quo
							quidem expedita inventore.</p>
					</div>
				</div>
			</div>
		</div>
		<div class="portals d-flex justify-content-center align-items-center">
			<div class="portals-left d-flex align-items-center">
				<div class="logo-portal">
					<img src="<%=themeDisplay.getPathThemeImages()%>/logo.png" alt="" />
				</div>
				<div style="margin-left: -10px" class="text-light fs-5 lh-1">
					<span> <!-- Our --> <liferay-ui:message key="our" />
					</span><br /> <span class="fw-bold"> <!-- Portals --> <liferay-ui:message
							key="portals" />
					</span>
				</div>
			</div>
			<div class="portals-right">
				<div
					class="owl-carousel owl-theme gap-3 d-flex w-100 overflow-hidden portal-cards">
					<div class="card" style="width: 100%; height: 120px">
						<a href="/food-grain-license-lc">
							<div
								class="card-body portal-card position-relative d-flex flex-column justify-content-center align-items-center">

								<i class="portal-card-icon bi bi-person fs-3 text-success px-3"></i>
								<h6 class="card-title text-center fw-normal">
									<!-- Food Grain License -->
									<liferay-ui:message key="food-grain-license" />
								</h6>
							</div>
						</a>
					</div>
					<div class="card" style="width: 100%; height: 120px">
						<a href="/food-grain-license-lc">
							<div
								class="card-body portal-card d-flex flex-column justify-content-center align-items-center">

								<i class="bi bi-person fs-3 text-success px-3"></i>
								<h6 class="card-title text-center fw-normal">
									<!-- Farmer -->
									<liferay-ui:message key="farmer" />
								</h6>
							</div>
						</a>
					</div>

					<div class="card" style="width: 100%; height: 120px">
						<a href="/food-grain-license-lc">
							<div
								class="card-body portal-card d-flex flex-column justify-content-center align-items-center">

								<i class="bi bi-person-square fs-3 text-success px-3"></i>
								<h6 class="card-title text-center fw-normal">
									<!--   Miller -->
									<liferay-ui:message key="miller" />
								</h6>
							</div>
						</a>
					</div>
					<div class="card" style="width: 100%; height: 120px">
						<a href="/food-grain-license-lc">
							<div
								class="card-body portal-card d-flex flex-column justify-content-center align-items-center">
								<!--       <div class="icon-show-hide position-absolute">
                  <i class="show-icon position-absolute fa-regular fa-eye"></i>
                  <i
                    class="hide-icon position-absolute fa-regular fa-eye-slash"
                  ></i>
                </div> -->
								<i class="bi bi-truck fs-3 text-success px-3"></i>
								<h6 class="card-title text-center fw-normal">
									<liferay-ui:message key="movement-contractor" />
								</h6>
							</div>
						</a>
					</div>
					<div class="card" style="width: 100%; height: 120px">
						<a href="/food-grain-license-lc">
							<div
								class="card-body portal-card d-flex flex-column justify-content-center align-items-center">

								<i class="bi bi-truck fs-3 text-success px-3"></i>
								<h6 class="card-title text-center fw-normal">
									<!-- Dealer -->
									<liferay-ui:message key="dealer" />
								</h6>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- owl carousel js and jQuery cdn -->

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"
		integrity="sha512-bPs7Ae6pVvhOSiIcyUClR7/q2OAsRiovw4vAkX+zJbw3ShAeeqezq50RIIcIURq7Oa20rW2n2q+fyXBNcU9lrw=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script>
		$(".owl-carousel")
				.owlCarousel(
						{
							loop : true,
							margin : 15,
							dots : false,
							nav : true,
							navText : [
									"<div class='car-nav-container'><i class='car-nav-icon fa-solid fa-angle-right'></i></div>", ],
							responsive : {
								0 : {
									items : 1,
								},
								600 : {
									items : 3,
								},
								1000 : {
									items : 4,
								},
							},
						});

		var cards = document.getElementsByClassName("portal-card");
		const showHide = document.getElementsByClassName("icon-show-hide");
		var myFunction = function() {
			this.classList.toggle("active");
		};

		for (var i = 0; i < showHide.length; i++) {
			showHide[i].addEventListener("click", myFunction, false);
		}
	</script>
</body>
</html>