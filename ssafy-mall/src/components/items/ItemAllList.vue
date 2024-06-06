<template>
    <section class="py-5">
      <div class="container-fluid">
        
        <div class="row">
          <div class="col-md-12">

            <div class="bootstrap-tabs product-tabs">
              <div class="tabs-header d-flex justify-content-between border-bottom my-5">
                <h3>전체 상품 보기</h3>
                <nav>
                  <div class="nav nav-tabs" id="nav-tab" role="tablist">
                    <a href="#" class="nav-link text-uppercase fs-6 active" id="nav-all-tab" data-bs-toggle="tab" data-bs-target="#nav-all">All</a>
                    <a href="#" class="nav-link text-uppercase fs-6" id="nav-fruits-tab" data-bs-toggle="tab" data-bs-target="#nav-fruits">카테고리1</a>
                    <a href="#" class="nav-link text-uppercase fs-6" id="nav-juices-tab" data-bs-toggle="tab" data-bs-target="#nav-juices">카테고리2</a>
                  </div>
                </nav>
              </div>
              <div class="tab-content" id="nav-tabContent">

                <div class="tab-pane fade show active" id="nav-all" role="tabpanel" aria-labelledby="nav-all-tab">

                  <div class="product-grid row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5">
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                  </div>
                  
                </div>

                <div class="tab-pane fade" id="nav-fruits" role="tabpanel" aria-labelledby="nav-fruits-tab">
                  
                  <div class="product-grid row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5">
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                  </div>

                </div>


                <div class="tab-pane fade" id="nav-juices" role="tabpanel" aria-labelledby="nav-juices-tab">

                  <div class="product-grid row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5">
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                    <div class="col"><ItemAllDetail /></div>
                  </div>
                  
                </div>
                
              </div>
            </div>

          </div>
        </div>
      </div>
    </section>
</template>

<script setup>
import ItemAllDetail from './ItemAllDetail.vue';
</script>

<style scoped>
 section {
  padding: 0px 100px 0px 100px;
 }
</style>