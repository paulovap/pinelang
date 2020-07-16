#!/bin/bash

# The website is built using MkDocs with the Material theme.
# https://squidfunk.github.io/mkdocs-material/
# It requires Python to run.
# Install the packages with the following command:
# pip install mkdocs mkdocs-material

set -ex

REPO="git@github.com:paulovap/pinelang.git"
DIR=temp-clone

# Delete any existing temporary website clone
rm -rf $DIR

# Clone the current repo into temp folder
git clone $REPO $DIR

# Move working directory into temp folder
cd $DIR

# Generate the API docs
./gradlew build :core:dokka :lsp:dokka


#set +x
#for MARKDOWN_FILE in $(find docs/ -name '*.md'); do
#  echo $MARKDOWN_FILE
#  title_markdown_file $MARKDOWN_FILE
#done
#set -x

# Copy in special files that GitHub wants in the project root.
cp Readme.md docs/
#cp CHANGELOG.md docs/changelog.md
#cp CONTRIBUTING.md docs/contributing.md

# Build the site and push the new files up to GitHub
mkdocs gh-deploy

# Delete our temp folder
#cd ..
#rm -rf $DIR