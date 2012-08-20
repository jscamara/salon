<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/fullcalendar.css' />" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/fullcalendar.print.css'/>" media='print'/>
		<style type='text/css'>
			body {
				margin-top: 40px;
				text-align: center;
				font-size: 14px;
				font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
				}
		
			#agenda {
				width: 1024px;
				margin: 0 auto;
			}
		</style>
		<title>Insert title here</title>
	</head>
	<body>
		<div id="agenda">
		</div>
		
		<script type='text/javascript' src="<c:url value='/js/jquery-1.7.2.min.js'/>"></script>
		<script type='text/javascript' src="<c:url value='/js/jquery-ui-1.8.23.custom.min.js'/>"></script>
		<script type='text/javascript' src="<c:url value='/js/fullcalendar.min.js'/>"></script>		
		<script type='text/javascript'>
			$(document).ready(function() {
				var calendar = $('#agenda').fullCalendar({
					header: {
						left: 'prev,next today',
						center: 'title',
						right: 'month,agendaWeek,agendaDay'
					},
					allDaySlot : false,
					columnFormat : {
						week : "ddd d/M",
						day: "dddd d/M"
					},
					weekMode : "liquid",
					minTime : 6,
					maxTime : 20,
					slotMinutes : 30,
					monthNames :[
						"<fmt:message key='month.january' />",
						"<fmt:message key='month.february' />",
						"<fmt:message key='month.march' />",
						"<fmt:message key='month.april' />",
						"<fmt:message key='month.may' />",
						"<fmt:message key='month.june' />",
						"<fmt:message key='month.july' />",
						"<fmt:message key='month.august' />",
						"<fmt:message key='month.september' />",
						"<fmt:message key='month.october' />",
						"<fmt:message key='month.november' />",
						"<fmt:message key='month.december' />"
					             ],
					monthNamesShort : [
						"<fmt:message key='month.short.january' />",
						"<fmt:message key='month.short.february' />",
						"<fmt:message key='month.short.march' />",
						"<fmt:message key='month.short.april' />",
						"<fmt:message key='month.short.may' />",
						"<fmt:message key='month.short.june' />",
						"<fmt:message key='month.short.july' />",
						"<fmt:message key='month.short.august' />",
						"<fmt:message key='month.short.september' />",
						"<fmt:message key='month.short.october' />",
						"<fmt:message key='month.short.november' />",
						"<fmt:message key='month.short.december' />"
					                   ],
					dayNames : [
						"<fmt:message key='day.sunday' />",
						"<fmt:message key='day.monday' />",
						"<fmt:message key='day.tuesday' />",
						"<fmt:message key='day.wednesday' />",
						"<fmt:message key='day.thursday' />",
						"<fmt:message key='day.friday' />",
						"<fmt:message key='day.saturday' />"
					            ],
	            dayNamesShort : [
						"<fmt:message key='day.short.sunday' />",
						"<fmt:message key='day.short.monday' />",
						"<fmt:message key='day.short.tuesday' />",
						"<fmt:message key='day.short.wednesday' />",
						"<fmt:message key='day.short.thursday' />",
						"<fmt:message key='day.short.friday' />",
						"<fmt:message key='day.short.saturday' />"
						            ],
					buttonText : {
						today : "<fmt:message key='today' />",
						day : "<fmt:message key='day' />",
						week : "<fmt:message key='week' />",
						month : "<fmt:message key='month' />"
					},
					selectable: true,
					selectHelper: true,
					select: function(start, end, allDay) {
						var title = prompt('Event Title:');
						if (title) {
							calendar.fullCalendar('renderEvent',
								{
									title: title,
									start: start,
									end: end,
									allDay: allDay
								},
								true // make the event "stick"
							);
						}
						calendar.fullCalendar('unselect');
					},
					editable: true,
					events: "${linkTo[AgendaController].getAppointmentsJson}"
				});
			});
		</script>
	</body>
</html>