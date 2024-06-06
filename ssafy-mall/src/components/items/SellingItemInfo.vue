<template>
    <section class="product-info-tabs py-5">
      <div class="container-fluid">
        <div class="row">
          <div class="d-flex flex-column flex-md-row align-items-start gap-5">
            <div class="nav flex-row flex-wrap flex-md-column nav-pills me-3 col-lg-3" id="v-pills-tab" role="tablist"
              aria-orientation="vertical">
              <button class="nav-link text-start active" id="v-pills-description-tab" data-bs-toggle="pill"
                data-bs-target="#v-pills-description" type="button" role="tab" aria-controls="v-pills-description"
                aria-selected="true">Description</button>
              <button class="nav-link text-start" id="v-pills-additional-tab" data-bs-toggle="pill"
                data-bs-target="#v-pills-additional" type="button" role="tab" aria-controls="v-pills-additional"
                aria-selected="false">Additional Information</button>
              <button class="nav-link text-start" id="v-pills-reviews-tab" data-bs-toggle="pill"
                data-bs-target="#v-pills-reviews" type="button" role="tab" aria-controls="v-pills-reviews"
                aria-selected="false">Customer Reviews</button>
            </div>
            <div class="tab-content" id="v-pills-tabContent">
              <div class="tab-pane fade show active" id="v-pills-description" role="tabpanel"
                aria-labelledby="v-pills-description-tab" tabindex="0">
                <h5>Product Description</h5>
                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros.
                  Nullam malesuada erat ut turpis. Suspendisse urna viverra non, semper suscipit, posuere a, pede. Donec
                  nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim
                  pellentesque felis. Phasellus ultrices nulla quis nibh. Quisque a lectus. Donec consectetuer ligula
                  vulputate sem tristique cursus.</p>
                <ul style="list-style-type:disc;" class="list-unstyled ps-4">
                  <li>Donec nec justo eget felis facilisis fermentum.</li>
                  <li>Suspendisse urna viverra non, semper suscipit pede.</li>
                  <li>Aliquam porttitor mauris sit amet orci.</li>
                </ul>
                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros.
                  Nullam malesuada erat ut turpis. Suspendisse urna viverra non, semper suscipit, posuere a, pede. Donec
                  nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim
                  pellentesque felis. Phasellus ultrices nulla quis nibh. Quisque a lectus. Donec consectetuer ligula
                  vulputate sem tristique cursus. </p>
              </div>
              <div class="tab-pane fade" id="v-pills-additional" role="tabpanel"
                aria-labelledby="v-pills-additional-tab" tabindex="0">
                <p>It is Comfortable and Best</p>
                <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
                  pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit
                  anim id est laborum. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                  fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia
                  deserunt mollit anim id est laborum.</p>
              </div>
              <div class="tab-pane fade" id="v-pills-reviews" role="tabpanel" aria-labelledby="v-pills-reviews-tab"
                tabindex="0">
                <div class="review-box d-flex flex-wrap">
                  <div class="col-lg-6 d-flex flex-wrap gap-3">
                    <div class="col-md-2">
                      <div class="image-holder">
                        <img src="@/assets/images/reviewer-1.jpg" alt="review" class="img-fluid rounded-circle">
                      </div>
                    </div>
                    <div class="col-md-8">
                      <div class="review-content">
                        <div class="rating-container d-flex align-items-center">
                          <div class="rating" data-rating="1">
                            <svg width="24" height="24" class="text-primary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <div class="rating" data-rating="2">
                            <svg width="24" height="24" class="text-primary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <div class="rating" data-rating="3">
                            <svg width="24" height="24" class="text-primary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <div class="rating" data-rating="4">
                            <svg width="24" height="24" class="text-secondary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <div class="rating" data-rating="5">
                            <svg width="24" height="24" class="text-secondary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <span class="rating-count">(3.5)</span>
                        </div>
                        <div class="review-header">
                          <span class="author-name">Tina Johnson</span>
                          <span class="review-date">– 03/07/2023</span>
                        </div>
                        <p>Vitae tortor condimentum lacinia quis vel eros donec ac. Nam at lectus urna duis convallis
                          convallis</p>
                      </div>
                    </div>
                  </div>
                  <div class="col-lg-6 d-flex flex-wrap gap-3">
                    <div class="col-md-2">
                      <div class="image-holder">
                        <img src="@/assets/images/reviewer-2.jpg" alt="review" class="img-fluid rounded-circle">
                      </div>
                    </div>
                    <div class="col-md-8">
                      <div class="review-content">
                        <div class="rating-container d-flex align-items-center">
                          <div class="rating" data-rating="1">
                            <svg width="24" height="24" class="text-primary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <div class="rating" data-rating="2">
                            <svg width="24" height="24" class="text-primary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <div class="rating" data-rating="3">
                            <svg width="24" height="24" class="text-primary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <div class="rating" data-rating="4">
                            <svg width="24" height="24" class="text-secondary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <div class="rating" data-rating="5">
                            <svg width="24" height="24" class="text-secondary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <span class="rating-count">(3.5)</span>
                        </div>
                        <div class="review-header">
                          <span class="author-name">Jenny Willis</span>
                          <span class="review-date">– 03/06/2022</span>
                        </div>
                        <p>Vitae tortor condimentum lacinia quis vel eros donec ac. Nam at lectus urna duis convallis
                          convallis</p>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="add-review mt-5">
                  <h3>Add a review</h3>
                  <p>Your email address will not be published. Required fields are marked *</p>
                  <form id="form" class="form-group">

                    <div class="pb-3">
                      <div class="review-rating">
                        <span>Your rating *</span>
                        <div class="rating-container d-flex align-items-center">
                          <div class="rating" data-rating="1">
                            <svg width="24" height="24" class="text-primary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <div class="rating" data-rating="2">
                            <svg width="24" height="24" class="text-primary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <div class="rating" data-rating="3">
                            <svg width="24" height="24" class="text-primary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <div class="rating" data-rating="4">
                            <svg width="24" height="24" class="text-secondary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <div class="rating" data-rating="5">
                            <svg width="24" height="24" class="text-secondary">
                              <use xlink:href="#star-solid"></use>
                            </svg>
                          </div>
                          <span class="rating-count">(3.5)</span>
                        </div>
                      </div>
                    </div>
                    <div class="pb-3">
                      <input type="file" class="form-control" data-text="Choose your file">
                    </div>
                    <div class="pb-3">
                      <label>Your Review *</label>
                      <textarea class="form-control" placeholder="Write your review here"></textarea>
                    </div>
                    <div class="pb-3">
                      <label>Your Name *</label>
                      <input type="text" name="name" placeholder="Write your name here" class="form-control">
                    </div>
                    <div class="pb-3">
                      <label>Your Email *</label>
                      <input type="text" name="email" placeholder="Write your email here" class="form-control">
                    </div>
                    <div class="pb-3">
                      <label>
                        <input type="checkbox" required>
                        <span class="label-body">Save my name, email, and website in this browser for the next
                          time.</span>
                      </label>
                    </div>
                    <button type="submit" name="submit"
                      class="btn btn-dark btn-large text-uppercase w-100">Submit</button>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
</template>