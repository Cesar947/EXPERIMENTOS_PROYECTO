<template>
  <div class="holder">
    <div class="preloader">
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
    </div>
    <h2>Buscando...</h2>
  </div>
</template>

<script>
export default {
  name: "loading"
};
</script>

<style lang="scss">
$count: 10;
$time: 2; //in seconds
$size: 100;
$color: #ffb677;

.preloader {
  /* size */
  width: $size + px;
  height: $size + px;

  animation: rotatePreloader $time + s infinite ease-in;
}
@keyframes rotatePreloader {
  0% {
    transform: rotateZ(0deg);
  }
  100% {
    transform: rotateZ(-360deg);
  }
}

.holder {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.holder h2 {
  font-weight: 600;
  font-size: 24px;
  margin-top: 24px;
  color: #434343;
}
.preloader div {
  position: absolute;
  width: 100%;
  height: 100%;
  opacity: 0;
}
.preloader div:before {
  content: "";
  position: absolute;
  left: 50%;
  top: 0%;
  width: 10%;
  height: 10%;
  background-color: $color;
  transform: translateX(-50%);
  border-radius: 50%;
}

@for $i from 1 through $count {
  .preloader div:nth-child(#{$i}) {
    transform: rotateZ(((360 / $count) * ($i - 1)) + deg);
    animation: rotateCircle + $i $time + s infinite linear;
    z-index: $count - $i;
  }
  @keyframes rotateCircle#{$i} {
    #{percentage(((50 / $count) * ($i - 1)) / 100)} {
      opacity: 0;
    }
    #{percentage((((50 / $count) + 0.0001) * ($i - 1)) / 100)} {
      opacity: 1;
      transform: rotateZ((0 - ((360 / $count) * ($i - 2))) + deg);
    }
    #{percentage((((50 / $count) * ($i - 0)) + 2) / 100)} {
      transform: rotateZ((0 - ((360 / $count) * ($i - 1))) + deg);
    }
    #{percentage(((50 + ((50 / $count) * ($i - 0))) + 2) / 100)} {
      transform: rotateZ((0 - ((360 / $count) * ($i - 1))) + deg);
    }
    100% {
      transform: rotateZ((0 - ((360 / $count) * ($count - 1))) + deg);
      opacity: 1;
    }
  }
}
</style>
