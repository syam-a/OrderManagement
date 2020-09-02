# OrderManagement
Sample Micro Services communications

http://localhost:8000/product/new
{        
		"productOrderCode":1,
        "productName": "Pen",
        "productQuantity": 6,
		"productPricePerUnit": 100
}

/product/order/code/{code}
/products
/product/code/{code}



http://localhost:8100/order/new

{  
	"customerName": "Syam",
	"orderDate": "06-02-2019",
	"shippingAddress":"Hyd"
}

/order/{code}
/order
