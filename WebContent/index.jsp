<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty sessionScope.customer}">
	<c:redirect url="login.jsp"/>
</c:if>
<c:if test="${empty pie || empty charts }">
	<c:redirect url="/ShowPie"/>
</c:if> 

<!DOCTYPE html>
<html lang="en">

  <head>
	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Main</title>
	<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
	<link href="css/sb-admin-2.min.css" rel="stylesheet">

  </head>

  <body id="page-top">
  
	<jsp:include page="head.jsp"></jsp:include>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                        <a href="ExportFile" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>

                    <!-- Content Row -->
                    <div class="row">

                        <!-- Earnings (Monthly) Card Example -->
                       
						 <c:forEach items="${pie}" var="p">	
							<c:choose>
								<c:when test="${p.cake.id == '1'}">
											<c:set var="total" value="${p.pound * p.quantity}" />
											<c:set var="totalall1" value="${totalall1+total}" />
								</c:when>
								<c:when test="${p.cake.id == '2'}">
											<c:set var="total2" value="${p.pound * p.quantity}" />
											<c:set var="totalall2" value="${totalall2+total2}" />
								</c:when>
								<c:when test="${p.cake.id == '3'}">
											<c:set var="total3" value="${p.pound * p.quantity}" />
											<c:set var="totalall3" value="${totalall3+total3}" />
								</c:when>
								<c:when test="${p.cake.id == '4'}">
											<c:set var="total4" value="${p.pound * p.quantity}" />
											<c:set var="totalall4" value="${totalall4+total4}" />
								</c:when>
								<c:otherwise>
					            			<c:set var="total5" value="${p.pound * p.quantity}" />
											<c:set var="totalall5" value="${totalall5+total5}" />
					         	</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${p.cake.id == '1'}">
											<c:set var="t1" value="${totalall1*190}" />
								</c:when>
								<c:when test="${p.cake.id == '2'}">
											<c:set var="t2" value="${totalall2*180}" />
								</c:when>
								<c:when test="${p.cake.id == '3'}">
											<c:set var="t3" value="${totalall3*220}" />
								</c:when>
								<c:when test="${p.cake.id == '4'}">
											<c:set var="t4" value="${totalall4*170}" />
								</c:when>
								<c:otherwise>
											<c:set var="t5" value="${totalall5*70}" />
					         	</c:otherwise>
							</c:choose>
							<c:set var="totalPond" value="${(totalall1+totalall2+totalall3+totalall4+totalall5)*10}"/>
						</c:forEach>
                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                Earnings</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">฿<c:out value="${t1+t2+t3+t4+t5-totalPond}"/></div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Order
                                            </div>
                                            <c:forEach items="${count}" var="count">
                                            	<c:set var="rowcount" value="${rowcount+1}" />
                                            </c:forEach>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"><c:out value="${rowcount}"/></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Pending Requests Card Example -->
                    </div>

                    <!-- Content Row -->

                    <div class="row">
                        <!-- Area Chart -->
                        <div class="col-xl-8 col-lg-7">
                            <c:set var="p1" value="${0}" />
                        	<c:set var="p2" value="${0}" />
                        	<c:set var="p3" value="${0}" />
                        	<c:set var="p4" value="${0}" />
                        	<c:set var="p5" value="${0}" />
                        	<c:set var="p6" value="${0}" />
                        	<c:set var="p7" value="${0}" />
                        	<c:forEach items="${charts}" var="order">	
							<c:choose>
								<c:when test="${order.receiveDate == '2020-12-25'}">
											<c:set var="p1" value="${p1+order.getTotalPound()}" />
								</c:when>
								<c:when test="${order.receiveDate == '2020-12-26'}">
											<c:set var="p2" value="${p2+order.getTotalPound()}" />
								</c:when>
								<c:when test="${order.receiveDate == '2020-12-27'}">
											<c:set var="p3" value="${p3+order.getTotalPound()}" />
								</c:when>
								<c:when test="${order.receiveDate == '2020-12-28'}">
											<c:set var="p4" value="${p4+order.getTotalPound()}" />
								</c:when>
								<c:when test="${order.receiveDate == '2020-12-29'}">
											<c:set var="p5" value="${p5+order.getTotalPound()}" />
								</c:when>
								<c:when test="${order.receiveDate == '2020-12-23'}">
											<c:set var="p6" value="${p6+order.getTotalPound()}" />
								</c:when>
								<c:otherwise>
											<c:set var="p7" value="${p7+order.getTotalPound()}" />
					         	</c:otherwise>
							</c:choose>
						</c:forEach>
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">ยอดสั่งซื้อ รายวัน</h6>
                                    <div class="dropdown no-arrow">
                                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                                            aria-labelledby="dropdownMenuLink">
                                            <div class="dropdown-header">Dropdown Header:</div>
                                            <a class="dropdown-item" href="#">Action</a>
                                            <a class="dropdown-item" href="#">Another action</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">Something else here</a>
                                        </div>
                                    </div>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-bar">
                                        <canvas id="myBarChart"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Pie Chart -->
                        <div class="col-xl-4 col-lg-5">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">ยอดสั่งซื้อ จำนวนปอนด์</h6>
                                    <div class="dropdown no-arrow">
                                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                                            aria-labelledby="dropdownMenuLink">
                                            <div class="dropdown-header">Dropdown Header:</div>
                                            <a class="dropdown-item" href="#">Action</a>
                                            <a class="dropdown-item" href="#">Another action</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">Something else here</a>
                                        </div>
                                    </div>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-pie pt-4 pb-2">
                                        <canvas id="myPieChart"></canvas>
                                    </div>
                                    <div class="mt-4 text-center small">
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-primary"></i> เค้กแยมผลไม้
                                        </span>
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-success"></i> เค้กกาแฟ
                                        </span>
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-info"></i> เค้กช็อกโกแลต
                                        </span>
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-danger"></i> เค้กเนยสด
                                        </span>
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-warning"></i> เค้กบัตเตอร์
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    	
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

<!-- Page level plugins -->

<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<jsp:include page="script.jsp"></jsp:include>
<!-- Page level custom scripts -->
<!-- <script src="js/demo/chart-bar-demo.js"></script>
<script src="js/demo/chart-pie-demo.js"></script>-->
<script type="text/javascript">
//Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';
// Pie Chart Example
var ctxx = document.getElementById("myPieChart");
var val1="${totalall1}";
var val2="${totalall2}";
var val3="${totalall3}";
var val4="${totalall4}";
var val5="${totalall5}";
var myPieChart = new Chart(ctxx, {
  type: 'doughnut',
  data: {
    labels: ["เค้กแยมผลไม้", "เค้กกาแฟ", "เค้กช็อกโกแลต", "เค้กเนยสด", "เค้กบัตเตอร์" ],
    datasets: [{
      data: [val1, val2, val3, val4, val5],
      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc', '#f00000', '#fddb00'],
      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf', '#dc0000', '#ffd500'],
      hoverBorderColor: "rgba(234, 236, 244, 1)",
    }],
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
    },
    legend: {
      display: false
    },
    cutoutPercentage: 80,
  },
});

//Set new default font family and font color to mimic Bootstrap's default styling
var valch1="${p1}";
var valch2="${p2}";
var valch3="${p3}";
var valch4="${p4}";
var valch5="${p5}";
var valch6="${p6}";
var valch7="${p7}";
function number_format(number, decimals, dec_point, thousands_sep) {
  // *     example: number_format(1234.56, 2, ',', ' ');
  // *     return: '1 234,56'
  number = (number + '').replace(',', '').replace(' ', '');
  var n = !isFinite(+number) ? 0 : +number,
    prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
    sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
    dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
    s = '',
    toFixedFix = function(n, prec) {
      var k = Math.pow(10, prec);
      return '' + Math.round(n * k) / k;
    };
  // Fix for IE parseFloat(0.55).toFixed(0) = 0;
  s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
  if (s[0].length > 3) {
    s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
  }
  if ((s[1] || '').length < prec) {
    s[1] = s[1] || '';
    s[1] += new Array(prec - s[1].length + 1).join('0');
  }
  return s.join(dec);
}

// Bar Chart Example
var ctx = document.getElementById("myBarChart");
var myBarChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ["25 Dec", "26 Dec", "27 Dec", "28 Dec", "29 Dec", "30 Dec", "31 Dec"],
    datasets: [{
      label: "All",
      backgroundColor: "#4e73df",
      hoverBackgroundColor: "#2e59d9",
      borderColor: "#4e73df",
      data: [valch1, valch2, valch3, valch4, valch5, valch6, valch7],
    }],
  },
  options: {
    maintainAspectRatio: false,
    layout: {
      padding: {
        left: 10,
        right: 25,
        top: 25,
        bottom: 0
      }
    },
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false,
          drawBorder: false
        },
        ticks: {
          maxTicksLimit: 7
        },
        maxBarThickness: 25,
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 100,
          maxTicksLimit: 5,
          padding: 10,
          // Include a dollar sign in the ticks
          callback: function(value, index, values) {
            return  number_format(value)+' Pound' ;
          }
        },
        gridLines: {
          color: "rgb(234, 236, 244)",
          zeroLineColor: "rgb(234, 236, 244)",
          drawBorder: false,
          borderDash: [2],
          zeroLineBorderDash: [2]
        }
      }],
    },
    legend: {
      display: false
    },
    tooltips: {
      titleMarginBottom: 10,
      titleFontColor: '#6e707e',
      titleFontSize: 14,
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
      callbacks: {
        label: function(tooltipItem, chart) {
          var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
          return datasetLabel +' : ' + number_format(tooltipItem.yLabel)+' Order';
        }
      }
    },
  }
});

</script>
</body>
</html>