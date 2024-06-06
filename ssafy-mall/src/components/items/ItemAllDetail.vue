<template>
    <div class="product-item">
        <a href="#" class="btn-wishlist"><svg width="24" height="24">
                <use xlink:href="#heart"></use>
            </svg></a>
        <figure>
            <a href="single-product.html" title="Product Title">
                <img src="@/assets/images/thumb-biscuits.png" class="tab-image">
            </a>
        </figure>
        <h3>Sunstar Fresh Melon Juice</h3>
        <span class="qty">1 Unit</span><span class="rating"><svg width="24" height="24" class="text-primary">
                <use xlink:href="#star-solid"></use>
            </svg> 4.5</span>
        <span class="price">$18.00</span>
        <div class="d-flex align-items-center justify-content-between">
            <div class="input-group product-qty">
                <span class="input-group-btn">
                    <button type="button" class="quantity-left-minus btn btn-danger btn-number" data-type="minus">
                        <svg width="16" height="16">
                            <use xlink:href="#minus"></use>
                        </svg>
                    </button>
                </span>
                <input type="text" id="quantity" name="quantity" class="form-control input-number" value="1">
                <span class="input-group-btn">
                    <button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus">
                        <svg width="16" height="16">
                            <use xlink:href="#plus"></use>
                        </svg>
                    </button>
                </span>
            </div>
            <a href="#" class="nav-link">Add to Cart <iconify-icon icon="uil:shopping-cart" /></a>
        </div>
    </div>
</template>