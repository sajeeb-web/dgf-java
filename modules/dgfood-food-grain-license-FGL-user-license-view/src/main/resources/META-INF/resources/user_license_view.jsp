<%@ include file="init.jsp"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.licnsUserRegs"%>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<%
	DgfFglLicDtls licDtlsObj = (DgfFglLicDtls) request.getAttribute("dgfFglLicDtlsObj");
	licnsUserRegs userRegsObj = (licnsUserRegs) request.getAttribute("userRegsObj");
	SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Grain License</title>
</head>

<body>
    <div class="px-5 mb-5">
        <hr class="mt-3 mb-1" />
        <portlet:resourceURL var="pdfResourceUrl">
    		<portlet:param name="resource" value="pdf" />
		</portlet:resourceURL>
        <div class="d-flex justify-content-between align-items-center">
        	<span class="fs-5 fw-bold p-0 m-0"><!-- Food Grain License --><liferay-ui:message key="food-grain-license"/></span>
        <span class="fs-5 fw-bold p-0 m-0"><a class="btn btn-success" href="<%=pdfResourceUrl %>" target="_blank">Download PDF</a>
        </span>
        </div>
        <hr class="mt-1 mb-3" />
        <div class="container">
            <div class="row">
                <div class="col-2">                   
                </div>
                <div class="col-8 text-center" >                    
                    <h5 class="m-0 p-0 fw-bold"><liferay-ui:message key="food-grain-license-view-head-1"/><!-- মূল কপি --></h5>                    
		              <h6 class="m-0 pt-3  green-text">
		              <liferay-ui:message key="food-grain-license-view-head-2"/>
                        <!-- গণপ্রজাতন্ত্রী বাংলাদেশ সরকার -->
		              </h6>
	
		              <h6 class="m-0 p-1 fw-bold">
		              <liferay-ui:message key="food-grain-license-view-head-4"/>
		                <!-- খাদ্য বিভাগ  -->
		              </h6>
                      <h6 class="m-0 p-1 fw-bold">
                      <liferay-ui:message key="food-grain-license-view-head-5"/>
		                <!-- খাদ্য অধিদপ্তর, ঢাকা । -->
		              </h6>
                      <h4 class="m-0 p-4 fw-bold text-decoration-underline"><liferay-ui:message key="food-grain-license-view-head-6"/><!-- খাদ্যশস্য/খাদ্য সামগ্রী ক্রয়-বিক্রয় ও গুদামজাতকরণের লাইসেন্স --></h4>
                </div>
                <div class="col-2 text-end">
                    <h6 class="m-0 p-0 text-decoration-underline ">
                    <liferay-ui:message key="food-grain-license-view-head-7"/>
                        <!-- খাদ্য শস্য লাইসেন্স ফর্ম-খ -->
                    </h6>
                    <h6 class="mt-2 p-0 ">
                    <liferay-ui:message key="food-grain-license-view-head-8"/><%=licDtlsObj.getFglApplicationNo() %> 
                        <!-- নং- --> 
                    </h6>
                    <div class="row me-1 mt-4">
                        <div class="col-3"></div>
                        <div class="col-9 text-center  border border-dark p-0">
                        <%-- <liferay-ui:message key="food-grain-license-view-head-9"/> --%>
                        <img class="img-fluid" alt="" src="<%=userRegsObj.getPhotographFile() %>"/>
                           <!--  ছবি -->
                        </div>
                    </div>                    
                </div>
            </div>         
            <div class="row">
                <div class="col "> 
                    <span><liferay-ui:message key="food-grain-license-view-option-1"/><%=licDtlsObj.getFoodgrainLicenseType() %> </span>                               
                </div>
                <div class="col text-center" >
                    <span><liferay-ui:message key="food-grain-license-view-option-2"/><%=licDtlsObj.getFoodgrainLicenseNo() %></span>                    
                </div>
                <div class="col text-end">
                    <span><liferay-ui:message key="food-grain-license-view-option-3"/> <%=newFormat.format(licDtlsObj.getFoodgrainLicenseIssueDate()) %></span>                    
                </div>
            </div>
            <div class="row">
                <div>
                    <p><liferay-ui:message key="food-grain-license-view-option-4"/><!-- Control of Essential Commodities Act, 1956 এর সেকশন-৩-এ প্রদত্ত ক্ষমতাবলে জারীকৃত এসআরও নং-১১২-আইন/২০১১ ও ১১৩-আইন/২০১১ তারিখঃ ২১ বৈশাখ ১৪১৮/৪ মে ২০১১ মোতাবেক --></p>
                </div>                
            </div>
            <div class="row">
                <div class="col "> 
                    <span><liferay-ui:message key="food-grain-license-view-option-5"/><%=userRegsObj.getApplicantName() %><!-- জনাব/মেসার্স : -->  </span>                               
                </div>
                <div class="col " >
                    <span><liferay-ui:message key="food-grain-license-view-option-6"/><%=userRegsObj.getApplicantName() %><!-- পিতা/প্রোপ্রাইটারের নাম :  --></span>                    
                </div>                
            </div>
            <div class="row">
                <div class="col "> 
                    <span><liferay-ui:message key="food-grain-license-view-option-7"/><%=userRegsObj.getBusinessHouseAddress() %><!-- গ্রাম/মহল্লা/হোল্ডিং : --> </span>                               
                </div>
                <div class="col " >
                    <span><liferay-ui:message key="food-grain-license-view-option-8"/><%=userRegsObj.getBusinessPostOffice() %><!-- ডাকঘর :  --></span>                    
                </div>                
            </div>
            <div class="row">
                <div class="col "> 
                    <span><liferay-ui:message key="food-grain-license-view-option-9"/><%=request.getAttribute("subDistrictName") %><!-- থানা/উপজেলা : --> </span>                               
                </div>
                <div class="col" >
                    <span><liferay-ui:message key="food-grain-license-view-option-10"/> <%=request.getAttribute("districtName") %><!-- জেলা : --> </span>                    
                </div>                
            </div>
            <div class="row">
                <div class="col "> 
                    <span><liferay-ui:message key="food-grain-license-view-option-11"/><%=userRegsObj.getNationalId() %><!-- জাতীয় পরিচয়পত্র নং :  --></span>                               
                </div>                             
            </div>
            <div class="row">
                <div>
                    <p><liferay-ui:message key="food-grain-license-view-option-12"/><!-- কে এতদ্বারা খাদ্যশস্য / খাদ্য সামগ্রী যথা : --> <span class="fw-bold"><liferay-ui:message key="food-grain-license-view-option-13"/> <!-- ধান, চাল, গম ও গমজাত দ্রব্য, ভোজ্য তেল (সয়াবিন ও পামওয়েল) চিনি ও ডাল  --></span> <liferay-ui:message key="food-grain-license-view-option-14"/><!-- নিম্নে উল্লিখিত শর্তাধীনে ক্রয়-বিক্রয় বা বিক্রয়ার্থে গুদামজাত করার ক্ষমতা প্রদান করা হইল। --></p>
                </div>                
            </div>
            <div class="row">
               <h5 class="col text-center fw-bold">
               <liferay-ui:message key="food-grain-license-view-shartabali"/>
                    <!-- : শর্তাবলী : -->
               </h5>                
            </div>
            <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-1"/><liferay-ui:message key="food-grain-license-view-shartabali-2"/><%=request.getAttribute("districtName") %><liferay-ui:message key="food-grain-license-view-shartabali-3"/><%=request.getAttribute("subDistrictName") %><liferay-ui:message key="food-grain-license-view-shartabali-4"/><%=userRegsObj.getBusinessHouseAddress() %>
                    <!-- ১। লাইসেন্সধারী অত্র --> <!--  জেলাধীন -->  <!-- থানা/উপজেলার -->  <!-- গ্রাম/মহল্লা/মৌজায় অবস্থিত দোকান / গুদাম / গুদামসমূহে উর্পযুক্ত খাদ্যশস্য /খাদ্য সামগ্রী বিক্রয়ার্থে মজুন/ গুদামজাত করিতে পারিবেন। -->
                </p>                
             </div>
             <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-5"/>....................................<liferay-ui:message key="food-grain-license-view-shartabali-6"/>....................................<liferay-ui:message key="food-grain-license-view-shartabali-7"/>
                   <!--  ২। অত্র লাইসেন্সের শর্তাধীনে আমদানীকারক/পাইকারী ব্যবসায়ী/খুচরা ব্যবসায়ী/চালকল মালিক সংশ্লিষ্ট এসআরও-তে নির্ধারিত -->  <!-- পরিমাণ ও --> <!-- খাদ্যশস্য/খাদ্য সামগ্রী সংরক্ষণ করিতে পারিবেন না।  -->
                </p>                
             </div>
             <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-8"/>
                    <!-- ৩। লাইসেন্সধারী খাদ্যশস্য, খাদ্যসামগ্রী পরিষ্কার স্থানে এবং স্বাস্থ্যসম্মত উপায়ে সংরক্ষণ করিবেন। -->
                </p>                
             </div>
             <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-9"/>
                   <!--  ৪। অত্র লাইসেন্সের অধীনে ব্যবসায়ে কোনরূপ ভেজাল মিশ্রণ কিংবা খাদ্যশস্য, খাদ্যসামগ্রীর খাদ্যমান বিনষ্ট হয় এরূপ যে কোন কার্যক্রম নিষিদ্ধ বলিয়া গণ্য হইবে। -->
                </p>                
             </div>
             <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-10"/>
                    <!-- ৫। আমদানীকারক/পাইকারী বিক্রেতা ২নং শর্তে উল্লিখিত এসআরও-তে অনুমোদিত মেয়াদের মধ্যে অনুমোদিত মজুদ তাহার নিয়ন্ত্রণ বহির্ভূত কারণে বিক্রয় করিতে না পারিলে অনুমোদিত মেয়াদ উত্তীর্ণ হইবার ৩ (তিন) দিনের মধ্যে বিষয়টি লাইসেন্স প্রদানকারী কর্মকর্তাকে নির্ধারিত ছকে (ফরম-গ) লিখিতভাবে অবহিত করিবেন। -->
                </p>                
             </div>
             <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-11"/>
                    <!-- ৬। অত্র লাইসেন্সধারীকে উপর্যুক্ত খাদ্যশস্য / খাদ্য সামগ্রী আমদানী, ক্রয়, মজুদ ও বিক্রয়ের হিসাব লাইসেন্স প্রদানকারী কর্তৃপক্ষের নির্দেশনা অনুযায়ী সংরক্ষণ করিতে হইবে এবং হিসাব বিবরণী নির্ধারিত ছকে (ফরম-ঘ) পাক্ষিক ভিত্তিতে লাইসেন্স প্রদানকারী কর্তৃপক্ষের নিকট দাখিল করিতে হইবে। -->
                </p>                
             </div>
             <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-12"/>
                    <!-- ৭। সরকার কর্তৃক বিশেষভাবে অব্যাহতিপ্রাপ্ত না হইলে লাইসেন্সধারী তাহার নিজের নাম, ঠিকানা ও লাইসেন্স নং লেনদেনের তারিখ, বিক্রিত খাদ্যশস্য/খাদ্য সামগ্রী, পরিমাণ (মেঃ টন / কুইন্টাল/কেজি), প্রতিমূল্য এবং দাবীকৃত মোট টাকা উল্লেখ করিয়া প্রত্যেক খরিদ্দারকে অবস্থামত নির্ভুল রসিদ বা চালান প্রদান করিবেন এবং উহার দ্বিতীয় কপি নিজের কাছে রাখিবেন, যাহা সরকারের নিকট হইতে পরিদর্শনের জন্য ক্ষমতাপ্রাপ্ত কোন অফিসার চাহিবামাত্র তাহাকে দেখাইতে হইবে। -->
                </p>                
             </div>
             <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-13"/>
                   <!--  ৮। লাইসেন্সধারী তাহার মজুদ হিসাব পরিদর্শনের জন্য উল্লিখিত দোকান / গুদাম বা গুদামসমূহ যাহা তিনি উপর্যুক্ত খাদ্যশস্য/খাদ্য সামগ্রী গুদামজাতকরণ বা বিক্রয়ের জন্য ব্যবহার করেন তাহা পরিদর্শনের এবং মজুদ পরিমাণ জানার জন্য এবং উহার মান -->
                </p>                
             </div>
             <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-14"/>
                   <!--  ৯। অত্র লাইসেন্সের কোন ধারার শর্তাবলী পালনে লাইসেন্সধারী ব্যর্থ হইলে বা লংঘন করিলে তাহা ১৯৫৬ সালের Control of Essential Commodities Act এর ধারা-৬ অনুযায়ী শাস্তিযোগ্য অপরাধ হিসাবে গণ্য হইবে। -->
                </p>                
             </div>
             <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-15"/>
                    <!-- ১০। যদি লাইসেন্স স্থগিত বা বাতিল বা প্রত্যর্পণ করা হয়, তাহা হইলে লাইসেন্স স্থগিত বা বাতিল সংক্রান্ত আদেশ জারী বা প্রত্যর্পণ আবেদনের ৭ দিনের মধ্যে যে অফিসার উহা প্রদান করিয়াছিলেন তাহার নিকট উহা জমা দিতে হইবে। -->
                </p>                
             </div>
             <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-16"/>
                   <!--  ১১। ৩০শে জুনের মধ্যে এই লাইসেন্স নবায়ন (পরবর্তী অর্থ বৎসরের জন্য) করিতে হইবে। নবায়নের জন্য দরখাস্তের সঙ্গে মূল (Origingal) লাইসেন্স দাখিল করিতে হইবে। -->
                </p>                
             </div>
             <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-17"/>
                    <!-- ১২। হারানো কিংবা দুর্ঘটনাজনিত কারণে লাইসেন্সের মূল কপি বিনষ্ট হইলে ৭ (সাত) দিনের মধ্যে লাইসেন্স প্রদানকারী কর্তৃপক্ষ ও নিকটস্থ থানায় অবহিত করিতে হইবে। -->
                </p>                
             </div>
             <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-18"/>
                    <!-- ১৩। এই লাইসেন্স হস্তান্তরযোগ্য নহে। -->
                </p>                
             </div>
             <div class="row">
                <p>
                <liferay-ui:message key="food-grain-license-view-shartabali-19"/><%=newFormat.format(licDtlsObj.getFoodgrainLicenseExpiryDate()) %>
                    <!-- ১৪। এই লাইসেন্সের মেয়াদ  -->
                </p>                
             </div>

             <div class="row pt-5">
                <div class="col "> 
                    <span><liferay-ui:message key="food-grain-license-view-shartabali-20"/><!-- লাইসেন্সধারী স্বাক্ষর --></span>                               
                </div>
                <div class="col text-center" >
                    <span><liferay-ui:message key="food-grain-license-view-shartabali-21"/><!-- লাইসেন্স প্রদানকারী অফিসের সীল --></span>                    
                </div>
                <div class="col text-end">
                    <span><liferay-ui:message key="food-grain-license-view-shartabali-22"/><!-- লাইসেন্স প্রদানকারী অফিসারের স্বাক্ষর পদবী ও সীল --></span>                    
                </div>
            </div>
             
        </div>
    </div>
</body>

</html>