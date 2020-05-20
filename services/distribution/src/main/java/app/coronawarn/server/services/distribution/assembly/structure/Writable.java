/*
 * Corona-Warn-App
 *
 * SAP SE and all other contributors /
 * copyright owners license this file to you under the Apache
 * License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package app.coronawarn.server.services.distribution.assembly.structure;

import app.coronawarn.server.services.distribution.assembly.structure.directory.Directory;
import app.coronawarn.server.services.distribution.assembly.structure.util.ImmutableStack;

/**
 * Something that has a name and can be written to somewhere.
 *
 * @param <W> The specific type of {@link Writable} that this {@link Writable} can be a child of.
 */
public interface Writable<W extends Writable<W>> {

  /**
   * Writes this {@link Writable} to disk.
   */
  void write();

  /**
   * Returns the name of this {@link Writable}.
   */
  String getName();

  /**
   * Returns the parent of this {@link Writable}, or {@code null} if it doesn't have a parent.
   */
  Directory<W> getParent();

  /**
   * Sets the parent of this {@link Writable}.
   */
  void setParent(Directory<W> parent);

  /**
   * Does preparation work for this {@link Writable} (e.g. calculate data, setup structures, etc.).
   */
  void prepare(ImmutableStack<Object> indices);

  boolean isFile();

  boolean isDirectory();

  boolean isArchive();
}
