FROM picoded/ubuntu-openjdk-8-jdk:16.04 as builder
WORKDIR /workspace
RUN apt-get update && apt-get install -y git && npm install -g yarn
# disable cache
ARG CACHEBUST=1
RUN git clone --depth=1 --branch=master https://github.com/triomino/eating-fish.git \
  && cd eating-fish  && yarn && yarn build
FROM nginx:1.15.8 as runner
COPY --from=builder /workspace/eating-fish/dist/* /usr/share/nginx/html/
