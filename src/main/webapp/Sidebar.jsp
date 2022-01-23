<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <link href="./css/style.css" rel="stylesheet">
<%String role=(String) session.getAttribute("role"); %>
<div class="quixnav">
            <div class="quixnav-scroll">
                <ul class="metismenu" id="menu"> 
                     
                    <li><a   href="Clients.jsp" aria-expanded="false"><i
                                class="icon icon-single-04"></i><span  >clients</span></a>
                        
                    </li>
                    
                    <li><a   href="Crenoms.jsp" ><i
                                class="icon icon-app-store"></i><span  >Crenom</span></a>
                        
                    </li>
                    <li><a  href="index2.jsp" ><i
                                class="icon icon-chart-bar-33"></i><span >Salles</span></a>
                      
                    </li>
                   

                    <li><a   href="Occupation.jsp" ><i
                                class="icon icon-plug"></i><span >Occupation</span></a>
                         
                    </li>
                     
                    <%if( role.equals("Admin") ){ %>
                    <li  id="regester"><a  href="resgister.jsp" aria-expanded="false"><i
                                class="icon icon-form "></i><span class="nav-text " >regester</span></a>
                      <%} %>
                    </li>
                   
                    <%if( role.equals("Admin") ){ %>
                    <li><a   href="Validation.jsp"  ><i
                                class="icon icon-single-copy-06"></i><span  >Validation</span></a>
                         </li>
                           <%} %>
                          <%if( role.equals("Admin") ){ %>
                    <li><a   href="Chart.jsp"  ><i
                                class="icon icon-single-copy-06"></i><span  >Chart</span></a>
                         </li>
                           <%} %>
                    </li>
                </ul>
            </div>


        </div>