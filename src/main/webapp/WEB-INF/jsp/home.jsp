<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Fear Factor</title>

<link rel="shortcut icon" href="public/img/favicon.png" type="image/x-icon"></link>
<link rel="stylesheet" type="text/css" media="screen" href="public/css/bootstrap.css"</link>
<link rel="stylesheet" type="text/css" media="screen" href="public/css/custom.css"</link>
<link rel="stylesheet" type="text/css" media="screen" href="public/css/footable.core.min.css"></link>

<script type="text/javascript" src="public/javascript/jquery/jquery.min.js"></script>
<script type="text/javascript" src="public/javascript/handlebars.min.js"></script>
<script type="text/javascript" src="public/javascript/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="public/javascript/underscore/underscore-min.js"></script>
<script type="text/javascript" src="public/javascript/backbone/backbone-min.js"></script>
<script type="text/javascript" src="public/javascript/footable.all.min.js")"></script>

</head>
<html lang="en">

<body>
	<script type="text/template" id="content-container-template">
                <div  class="content-container"></div>
        </script>

        <script type="text/template" id="country-container-template">
	  <div class="country-data-container">

	  </div>
          <hr/>
          <div class="continent-data-container">

	  </div>
	</script>
	
	<script type="text/template" id="country-table-template">
            <br/><h4>Country List</h4> <br/><button id="create-button" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> Add Country</button><br/>
            <table id="country-table" class="footable table-striped" data-page-size="25">
              <thead>
                <tr>
                  <th data-sort-initial="descending">Name</th>
                  <th data-hide="phone">Continent</th>
                  <th data-hide="phone">Population (mil)</th>
                  <th data-hide="phone">GDP ($bl)</th>
                  <th data-hide="phone,tablet">Aggression Level (1 - 10)</th>
                  <th data-hide="phone">Fear Factor</th>
                  <th data-sort-ignore="true"></th>
                </tr>
              </thead>
              <tbody id="country-table-body">

              </tbody>
            </table>
	</script>

        <script type="text/template" id="country-row-template">
            <td>{{name}}</td>
            <td>{{continent.name}}</td>
            <td>{{population}}</td>
            <td>{{gdp}}</td>
            <td>{{aggression}}</td>
            <td>{{fearFactor}}</td>
            <td><span id="trash" class="glyphicon glyphicon-trash"></span></td>
	</script>

	<script type="text/template" id="create-template">
            <!--  Share model modal -->
            <div id="create-modal" class="modal fade" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
              <div class="modal-dialog modal-sm">
                <div class="modal-content">
                  <div class="modal-header">
                    <h4 class="modal-title" id="modalLabel">Add Country</h4>
                  </div>
                    <div class="modal-body">
                        <input id="name" class="form-control" name="name" placeholder="Enter Country Name"></input>
                    </div>
                    <div class="modal-body">
                        <select id="continent" class="form-control">
                            <option value="0" selected="selected">Select Continent</option>
                            <option value="1">Europe</option>
                            <option value="2">Asia</option>
                            <option value="3">North America</option>
                            <option value="4">South America</option>
                            <option value="5">Africa</option>
                            <option value="6">Australia</option>
                        </select>
                    </div>
                    <div class="modal-body">
                        <input type="number" id="population" class="form-control" placeholder="Enter Population"></input>
                    </div>
                    <div class="modal-body">
                        <input type="number" id="gdp" class="form-control" placeholder="Enter GDP"></input>
                    </div>
                    <div class="modal-body">
                        <input type="number"  id="aggression" class="form-control" placeholder="Enter Aggression Level"></input>
                    </div>
                    <div class="modal-footer">
                        <button id="cancel-button" type="button" class="btn btn-default">Cancel</button>
                        <button id="add-button" type="button" class="btn btn-success">Add</button>
                    </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div>
	</script>
	
	<script type="text/template" id="continent-table-template">  
	  <div class="continent-data-container">
            <h4>Continent List</h4><br/>
	  </div>   
            <table id="continent-table" class="footable table-striped" data-page-size="25">
              <thead>
                <tr>
                  <th data-sort-initial="descending">Name</th>
                  <th data-hide="phone">Aggregate Fear Factor</th>
                </tr>
              </thead>
              <tbody id="continent-table-body">

              </tbody>
            </table>
	</script>

        <script type="text/template" id="continent-row-template">
            <td>{{name}}</td>
            <td>{{totalFearFactor}}</td>
	</script>

        <div class="main-container">
            <header class="navbar navbar-default navbar-static-top" role="navigation">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <div class="navbar-text image">
                    <img alt="" src="public/img/PhoenicianCoinSmall.png" width="20" height="20"/>
                </div>
                <div class="navbar-text navbar-left">
                    <h3>Fear Factor<h3>
                </div>
              </div>
              <div class="navbar-text navbar-right">

              </div>
            </header>		

            <div class="container">
                
            </div>

            <script type="text/javascript" src="public/javascript/main.js"></script>
            <script type="text/javascript" src="public/javascript/fear.js")"></script>

            <footer class="bs-footer" role="contentinfo">&copy; Project Phoenicia, 2014</footer>
        </div>
</body>

</html>