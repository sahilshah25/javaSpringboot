console.log("this is script file")

console.log($);

//first request to server to create a order

const paymentStart=()=>{
console.log("payment started...");

let amount=$("#payment_field").val()
console.log(amount);
if(amount==''||amount==null){
	alert("amount is required !!" );
	return;
	
	if(response.status=='created'){
		
		
		
	}
	
	
}

//we will use ajax to send request to server to create order= jquery ajax

$.ajax(
	
	{
		
		url:"/payment/create_order",
		data:JSON.stringify({amount:amount,info:'order_request'}),
		contentType:"application/json",
		type:"post",
		dataType:"json",
		success:function(response){
			//invoked when when success
			if(response.status=='created'){
					//open payment form
					
					let  options={
						key:"rzp_test_hzbWmiHVbcxepb",
						amount:response.amount,
						currency:'INR',
						name:'smart contact manager donation',
						discription:'Donation',
						image:"https://www.freepik.com/premium-vector/eps10-vector-letter-c-o-linked-logo-element-template-connect-technology-symbol_39288558.htm#fromView=keyword&page=1&position=12&uuid=61d543d9-d7b7-4143-8e11-9f4c11b990bd&new_detail=true",
						
						order_id:response.id,
						
						handler:function(response){
							console.log(response.razorpay_payment_id)
							console.log(response.log(razorpay_signature))
							console.log("payment sucessfull");
							alert("congrate !! payment sucessfull");
							
						},
						prefill: { //We recommend using the prefill parameter to auto-fill customer's contact information especially their phone number
						        "name": "", //your customer's name
						        "email": "",
						        "contact": "" //Provide the customer's phone number for better conversion rates 
						    },
							notes: {
							       "address": "sahil ahmad shah"
							   },
							   theme: {
							           "color": "#3399cc"
							       }
					};
					let rzp=new Razorpay(options);
					
					
					rzp.on("payment.failed",function(response){
					    console.log(response.error.code);
					    console.log(response.error.discription);
					    console.log(response.error.source);
					    console.log(response.error.step);
					    console.log(response.error.reason);
					    console.log(response.error.metadata.order_id);
					    console.log(response.error.metadata.payment_id);
						
						alert("oops payment failed");
						
					});
					
					
					
					rzp.open()
					
				}
				
			
			
			console.log(response)
		},
		
		error:function(error){
		//invoked when error
		
		console.log(error);
		alert("something went wrong !!")
		
		},
		
	}
	
	
)







};